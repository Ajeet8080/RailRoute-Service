package com.ajeet.Train.controller;

import com.ajeet.Train.entity.Station;
import com.ajeet.Train.entity.train;
import com.ajeet.Train.entity.trainSchedule;
import com.ajeet.Train.repo.StationRepository;
import com.ajeet.Train.repo.trainRepository;
import com.ajeet.Train.repo.trainScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class test {

    @Autowired
    StationRepository stationRepository;

    @Autowired
     trainRepository trainRepository;

    @Autowired
     trainScheduleRepository trainScheduleRepository;

    @GetMapping
    public void test() {


        Station delhi = new Station(null, "New Delhi", "NDLS");
        Station mumbai = new Station(null, "Mumbai Central", "CST");
        Station kolkata = new Station(null, "Kolkata", "KOAA");
        Station chennai = new Station(null, "Chennai Central", "MAS");

        stationRepository.saveAll(List.of(delhi, mumbai, kolkata, chennai));

        train rajdhani = new train(null, "Rajdhani Express", "12306", null);
        train duronto = new train(null, "Duronto Express", "12260", null);
        train shatabdi = new train(null, "Shatabdi Express", "12043", null);

        trainRepository.saveAll(List.of(rajdhani, duronto, shatabdi));

        trainSchedule sc1 = new trainSchedule(null, rajdhani, delhi, mumbai, "06:00", "14:00");
        trainSchedule sc2 = new trainSchedule(null, duronto, mumbai, kolkata, "08:00", "18:00");
        trainSchedule sc3 = new trainSchedule(null, shatabdi, kolkata, chennai, "11:00", "19:00");

        trainScheduleRepository.saveAll(List.of(sc1, sc2, sc3));

        System.out.println(" Data inserted in  successfully!");
    }
}
