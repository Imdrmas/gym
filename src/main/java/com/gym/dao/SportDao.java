package com.gym.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gym.model.Sport;

@Repository
public interface SportDao extends JpaRepository<Sport, Long> {

}
