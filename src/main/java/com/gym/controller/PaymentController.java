package com.gym.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.gym.dto.PaymentDto;
import com.gym.manager.PaymentManagerService;


@RestController
@RequestMapping("api")
@CrossOrigin(origins = "*")
public class PaymentController {
	
	@Autowired
	private PaymentManagerService paymentManagerService;

	@PostMapping("/addPayment/{idSportsMan}")
	PaymentDto addPayment(@RequestBody PaymentDto payment, @PathVariable Long idSportsMan) {
		return paymentManagerService.addPayment(payment, idSportsMan);
	}
	
	@PutMapping("/editPayment/{id}")
	PaymentDto editPayment(@RequestBody PaymentDto payment, @PathVariable Long id) {
		return paymentManagerService.editPayment(payment, id);
	}
	
	@DeleteMapping("/deletePayment/{id}")
	void deletePayment(@PathVariable Long id) {
		paymentManagerService.deletePayment(id);
	}
	
	@GetMapping("/findPaymentById/{id}")
	PaymentDto findPaymentById(@PathVariable Long id) {
		return paymentManagerService.findPaymentById(id);
	}
	
	@GetMapping("/findPaymentForSportsMan/{idSportsMan}")
	List<PaymentDto> findPaymentsForSportsMan(@PathVariable Long idSportsMan) {
		return paymentManagerService.findPaymentsForSportsMan(idSportsMan);
	}
}
