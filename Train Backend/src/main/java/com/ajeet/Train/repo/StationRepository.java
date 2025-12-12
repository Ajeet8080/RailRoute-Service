package com.ajeet.Train.repo;

import com.ajeet.Train.entity.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StationRepository extends JpaRepository<Station,Long> {
}
