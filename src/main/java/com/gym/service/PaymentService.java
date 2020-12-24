package com.gym.service;

import com.gym.model.Payment;
import com.gym.model.SportsMan;

public interface PaymentService {

	Payment addPayment(Payment payment, SportsMan sportsMan);
	
	Payment editPayment(Payment payment, Payment existPayment);
	
}
