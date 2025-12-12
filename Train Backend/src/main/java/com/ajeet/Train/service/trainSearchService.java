package com.ajeet.Train.service;

import com.ajeet.Train.entity.trainSchedule;
import com.ajeet.Train.repo.trainScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class trainSearchService {

    private trainScheduleRepository trainScheduleRepository;

     public trainSearchService(trainScheduleRepository trainScheduleRepository)
     {
        this.trainScheduleRepository=trainScheduleRepository;
     }

     public List<trainSchedule> findtrainByStationCode(String sourceCode,String destinationCode)
     {
        return trainScheduleRepository.
                findBySource_StationCodeAndDestination_StationCode(sourceCode,destinationCode);
     }

     public List<trainSchedule> findtrainByStationName(String sourceName,String destinationName)
     {
       return trainScheduleRepository.
               findBySource_StationNameAndDestination_StationName(sourceName,destinationName);
     }

}
