package com.gym.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gym.model.Gym;

@Repository
public interface GymDao extends JpaRepository<Gym, Long> {

}
