package com.gym.manager;

import java.util.List;
import com.gym.dto.PaymentDto;


public interface PaymentManagerService {

	PaymentDto addPayment(PaymentDto payment, Long idSportsMan);
	
	PaymentDto editPayment(PaymentDto payment, Long id);
	
	void deletePayment(Long id);
	
	PaymentDto findPaymentById(Long id);
	
	List<PaymentDto> findPaymentsForSportsMan(Long idSportsMan);
}
