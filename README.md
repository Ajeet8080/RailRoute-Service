# 🚆 Train Management API

A Spring Boot 3.5 project for managing train-related operations with REST APIs, MySQL persistence, and JPA-based data handling.

## 📌 Overview

This application provides a backend system for handling train data, including adding, updating, retrieving, and deleting train records. It is built using **Spring Boot**, **Spring Web**, **Spring Data JPA**, and **MySQL**.

## 🚀 Features

* RESTful API endpoints for trains
* JPA/Hibernate integration
* MySQL database support
* Input validation using Spring Validation
* Hot reload using Spring Boot DevTools (optional)
* Simple and clean project structure

## 🛠️ Tech Stack

* **Java 21**
* **Spring Boot 3.5.6**
* **Spring Web**
* **Spring Data JPA**
* **MySQL Connector-J**
* **Lombok** (Optional)
* **Maven**

## 📂 Project Structure

```
project-root
 ├── src/main/java/...   # Application source code
 ├── src/main/resources   # Application properties
 ├── pom.xml              # Maven dependencies
 ├── HELP.md              # Spring Boot help docs
 ├── .gitignore
 └── .gitattributes
```

## ⚙️ Setup Instructions

### 1. Clone the repository

```
git clone <your-repo-url>
cd project-root
```

### 2. Configure MySQL database

Update `application.properties`:

```
spring.datasource.url=jdbc:mysql://localhost:3306/train_db
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
```

### 3. Run the application

Using Maven:

```
./mvnw spring-boot:run
```

Or using your IDE (IntelliJ, Eclipse, VS Code).

📸 UI Screenshots

🔹 Dashboard Screenshot
![WhatsApp Image 2025-12-12 at 2 47 11 PM](https://github.com/user-attachments/assets/348e8ce7-5316-431c-a6c2-c33b8a376b87)


🔹 Train List Page
![WhatsApp Image 2025-12-12 at 2 47 51 PM](https://github.com/user-attachments/assets/534650d4-5e57-4b65-b204-f9f8b6a72765)


## 📡 API Endpoints (Example)

| Method | Endpoint     | Description          |
| ------ | ------------ | -------------------- |
| GET    | /trains      | Get all trains       |
| GET    | /trains/{id} | Get train by ID      |
| POST   | /trains      | Add new train        |
| PUT    | /trains/{id} | Update train details |
| DELETE | /trains/{id} | Delete train         |

## 🧪 Running Tests

```
mvn test
```

## 🧭 Roadmap

* Add authentication (JWT)
* Implement search/filter functionality
* Add Swagger UI documentation
* Add pagination & sorting


---

Feel free to ask for customization, API documentation, architecture diagram, or code generation!
