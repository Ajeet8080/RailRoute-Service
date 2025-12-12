package com.ajeet.Train.controller;

import com.ajeet.Train.entity.trainSchedule;
import com.ajeet.Train.service.trainSearchService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/search")
@CrossOrigin
public class trainSearchController {

    private trainSearchService trainSearchService;

    private trainSearchController(trainSearchService trainSearchService)
    {
        this.trainSearchService=trainSearchService;
    }

    @GetMapping("/by-code")
    public List<trainSchedule> findtrainByStationCode(@RequestParam String sourceCode, @RequestParam String destinationCode)
    {
       return trainSearchService.findtrainByStationCode(sourceCode.toUpperCase(),destinationCode.toUpperCase());
    }

    @GetMapping("/by-name")
    public List<trainSchedule> findtrainByStationName(@RequestParam String sourceName, @RequestParam String destinationName)
    {
        return trainSearchService.findtrainByStationName(sourceName.toUpperCase(),destinationName.toUpperCase());
    }
}
