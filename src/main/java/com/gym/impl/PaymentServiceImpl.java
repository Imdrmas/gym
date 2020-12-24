package com.gym.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.gym.dao.PaymentDao;
import com.gym.model.Payment;
import com.gym.model.SportsMan;
import com.gym.service.PaymentService;

@Component
public class PaymentServiceImpl implements PaymentService {
	
	@Autowired
	private PaymentDao paymentDao;

	@Override
	public Payment addPayment(Payment payment, SportsMan sportsMan) {
		sportsMan.addPayment(payment);
		return paymentDao.save(payment);
	}

	@Override
	public Payment editPayment(Payment payment, Payment existPayment) {
		existPayment.setCost(payment.getCost());
		existPayment.setDate(payment.getDate());
		existPayment.setDuration(payment.getDuration());
		return paymentDao.save(existPayment);
	}



}
