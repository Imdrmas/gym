package com.gym.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gym.model.Payment;

@Repository
public interface PaymentDao extends JpaRepository<Payment, Long> {

}
