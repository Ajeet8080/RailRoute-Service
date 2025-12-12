package com.ajeet.Train.service;

import com.ajeet.Train.entity.train;
import com.ajeet.Train.repo.trainRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class trainService {

    private final trainRepository trainRepository;

    public trainService(trainRepository trainRepository) {
        this.trainRepository = trainRepository;
    }

    public List<train> getAllTrains() {
        return trainRepository.findAll();
    }

    public train addtrain(train train) {
        return trainRepository.save(train);
    }
}
