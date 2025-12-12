package com.ajeet.Train.repo;

import com.ajeet.Train.entity.train;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface trainRepository extends JpaRepository<train,Long> {
}
