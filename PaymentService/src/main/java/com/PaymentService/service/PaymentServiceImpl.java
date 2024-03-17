package com.PaymentService.service;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PaymentService.entity.PaymentDetails;
import com.PaymentService.model.PaymentMode;
import com.PaymentService.model.PaymentRequest;
import com.PaymentService.model.PaymentResponse;
import com.PaymentService.repository.PaymentRepo;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class PaymentServiceImpl implements PaymentService{

	@Autowired
	private PaymentRepo repo;
	
	@Override
	public long doPayment(PaymentRequest paymentRequest) {
		log.info("PaymentRequest in PaymentRequestImpl ::"+paymentRequest);
		PaymentDetails paymentDetails=PaymentDetails.builder()
				.amount(paymentRequest.getAmount())
				.paymentDate(Instant.now())
				.paymentMode(paymentRequest.getPaymentMode().name())
				.paymentStatus("Success")
				.orderId(paymentRequest.getOrderId())
				.build();
		log.info("paymentDetails in doPayment"+paymentDetails);
		repo.save(paymentDetails); 
		return paymentDetails.getPaymentId();
	}

	@Override
	public PaymentResponse getPaymentDetails(Long orderId) {
			// TODO Auto-generated method stub
			PaymentDetails paymentDetails=repo.findByOrderId(orderId);
			PaymentResponse paymentResponse=PaymentResponse.builder()
					.amount(paymentDetails.getAmount())
					.orderId(paymentDetails.getOrderId())
					.paymentDate(paymentDetails.getPaymentDate())
					.paymentId(paymentDetails.getPaymentId())
					.status(paymentDetails.getPaymentStatus())
					.paymentMode(PaymentMode.valueOf(paymentDetails.getPaymentMode()))
					.build();
			return paymentResponse;
	}

}
