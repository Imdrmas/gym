package com.gym.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gym.model.Train;

@Repository
public interface TrainDao extends JpaRepository<Train, Long> {

}
