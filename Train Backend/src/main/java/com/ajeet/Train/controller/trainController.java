package com.ajeet.Train.controller;

import com.ajeet.Train.entity.train;

import com.ajeet.Train.service.trainService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/trains")
public class trainController {

    private trainService trainService;

    public trainController(trainService trainService)
    {
        this.trainService = trainService;
    }

    @GetMapping
    public List<train> getAllTrains() {
        return trainService.getAllTrains();
    }
    @PostMapping
    public train addTrain(@RequestBody train train){
        return trainService.addtrain(train);
    }
}
