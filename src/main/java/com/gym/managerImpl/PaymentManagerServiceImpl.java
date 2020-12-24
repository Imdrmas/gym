package com.gym.managerImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gym.dao.PaymentDao;
import com.gym.dao.SportsManDao;
import com.gym.dto.PaymentDto;
import com.gym.manager.PaymentManagerService;
import com.gym.model.OrikaBeanMapper;
import com.gym.model.Payment;
import com.gym.model.SportsMan;
import com.gym.service.PaymentService;

@Transactional
@Service
public class PaymentManagerServiceImpl implements PaymentManagerService {
	
	@Autowired
	private OrikaBeanMapper orikaBeanMapper;
	
	@Autowired
	private PaymentService paymentService;
	
	@Autowired
	private PaymentDao paymentDao;
	
	@Autowired
	private SportsManDao sportsManDao;

	@Override
	public PaymentDto addPayment(PaymentDto paymentDto, Long idSportsMan) {
		SportsMan sportsMan = sportsManDao.findById(idSportsMan).orElse(null);
		Payment payment = orikaBeanMapper.map(paymentDto, Payment.class);
		return orikaBeanMapper.convertDTO(paymentService.addPayment(payment, sportsMan), PaymentDto.class);
	}

	@Override
	public PaymentDto editPayment(PaymentDto paymentDto, Long id) {
		Payment payment = orikaBeanMapper.map(paymentDto, Payment.class);
		Payment existsPayment = paymentDao.findById(id).orElse(null);
		return orikaBeanMapper.convertDTO(paymentService.editPayment(payment, existsPayment), PaymentDto.class);
	}

	@Override
	public void deletePayment(Long id) {
		Payment existsPayment = paymentDao.findById(id).orElse(null);
		paymentDao.delete(existsPayment);
		
	}

	@Override
	public PaymentDto findPaymentById(Long id) {
		return orikaBeanMapper.convertDTO(paymentDao.findById(id).orElse(null), PaymentDto.class);
	}

	@Override
	public List<PaymentDto> findPaymentsForSportsMan(Long idSportsMan) {
		SportsMan sportsMan = sportsManDao.findById(idSportsMan).orElse(null);
		List<Payment> payments = sportsMan.getPayments();
		return orikaBeanMapper.convertListDTO(payments, PaymentDto.class);
	}

}
