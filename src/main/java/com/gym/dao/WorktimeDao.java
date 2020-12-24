package com.gym.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gym.model.Worktime;

@Repository
public interface WorktimeDao extends JpaRepository<Worktime, Long> {

}
