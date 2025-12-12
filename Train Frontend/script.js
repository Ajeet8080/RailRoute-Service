const API_BASE_URL = 'http://localhost:8080';

const elements = {
    searchForm: document.getElementById('searchForm'),
    sourceCode: document.getElementById('sourceCode'),
    destinationCode: document.getElementById('destinationCode'),
    swapBtn: document.getElementById('swapBtn'),
    loadingSpinner: document.getElementById('loadingSpinner'),
    errorMessage: document.getElementById('errorMessage'),
    errorText: document.getElementById('errorText'),
    resultsContainer: document.getElementById('resultsContainer'),
    trainList: document.getElementById('trainList'),
    resultsCount: document.getElementById('resultsCount')
};

elements.searchForm.addEventListener('submit', handleSearch);
elements.swapBtn.addEventListener('click', swapStations);

async function handleSearch(e) {
    e.preventDefault();
    
    const sourceCode = elements.sourceCode.value.trim().toUpperCase();
    const destinationCode = elements.destinationCode.value.trim().toUpperCase();
    
    if (!sourceCode || !destinationCode) {
        showError('Please enter both source and destination station codes');
        return;
    }
    
    if (sourceCode === destinationCode) {
        showError('Source and destination cannot be the same');
        return;
    }
    
    hideAll();
    showLoading();
    
    try {
        const response = await fetch(
            `${API_BASE_URL}/search/by-code?sourceCode=${sourceCode}&destinationCode=${destinationCode}`
        );
        
        if (!response.ok) {
            throw new Error(`HTTP error! Status: ${response.status}`);
        }
        
        const trains = await response.json();
        hideLoading();
        
        if (trains.length === 0) {
            showError('No trains found for the selected route');
        } else {
            displayResults(trains);
        }
    } catch (error) {
        hideLoading();
        showError(`Failed to fetch trains: ${error.message}`);
        console.error('Error:', error);
    }
}

function swapStations() {
    const temp = elements.sourceCode.value;
    elements.sourceCode.value = elements.destinationCode.value;
    elements.destinationCode.value = temp;
}

function displayResults(trains) {
    elements.resultsContainer.classList.remove('hidden');
    elements.resultsCount.textContent = `${trains.length} train${trains.length !== 1 ? 's' : ''} found`;
    
    elements.trainList.innerHTML = trains.map(train => createTrainCard(train)).join('');
}

function createTrainCard(data) {
    const duration = calculateDuration(data.departureTime, data.arrivalTime);
    
    return `
        <div class="train-card">
            <div class="train-header">
                <div class="train-info">
                    <div class="train-name">${data.train.trainName}</div>
                    <div class="train-number">#${data.train.trainNumber}</div>
                </div>
            </div>
            
            <div class="train-route">
                <div class="station departure">
                    <div class="station-name">${data.source.stationName}</div>
                    <div class="station-code">${data.source.stationCode}</div>
                    <div class="time">${formatTime(data.departureTime)}</div>
                </div>
                
                <div class="route-line">
                    <div class="route-arrow"></div>
                    <div class="duration">${duration}</div>
                </div>
                
                <div class="station arrival">
                    <div class="station-name">${data.destination.stationName}</div>
                    <div class="station-code">${data.destination.stationCode}</div>
                    <div class="time">${formatTime(data.arrivalTime)}</div>
                </div>
            </div>
        </div>
    `;
}

function formatTime(time) {
    const [hours, minutes] = time.split(':');
    const hour = parseInt(hours);
    const ampm = hour >= 12 ? 'PM' : 'AM';
    const displayHour = hour % 12 || 12;
    return `${displayHour}:${minutes} ${ampm}`;
}

function calculateDuration(departure, arrival) {
    const [depHour, depMin] = departure.split(':').map(Number);
    const [arrHour, arrMin] = arrival.split(':').map(Number);
    
    let totalMinutes = (arrHour * 60 + arrMin) - (depHour * 60 + depMin);
    
    if (totalMinutes < 0) {
        totalMinutes += 24 * 60;
    }
    
    const hours = Math.floor(totalMinutes / 60);
    const minutes = totalMinutes % 60;
    
    return `${hours}h ${minutes}m`;
}

function showLoading() {
    elements.loadingSpinner.classList.remove('hidden');
}

function hideLoading() {
    elements.loadingSpinner.classList.add('hidden');
}

function showError(message) {
    elements.errorText.textContent = message;
    elements.errorMessage.classList.remove('hidden');
}

function hideAll() {
    elements.loadingSpinner.classList.add('hidden');
    elements.errorMessage.classList.add('hidden');
    elements.resultsContainer.classList.add('hidden');
}