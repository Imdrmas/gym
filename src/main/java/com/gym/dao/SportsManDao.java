package com.gym.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gym.model.SportsMan;

@Repository
public interface SportsManDao extends JpaRepository<SportsMan, Long> {

}
