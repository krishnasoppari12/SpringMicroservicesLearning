package com.PaymentService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PaymentService.model.PaymentRequest;
import com.PaymentService.model.PaymentResponse;
import com.PaymentService.service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {

	@Autowired
	private PaymentService paymentService;
	
	@PostMapping("/doPayment")
	public ResponseEntity<Long> doPayment(@RequestBody PaymentRequest paymentRequest){
		long paymentId=paymentService.doPayment(paymentRequest);
		return new ResponseEntity<>(paymentId,HttpStatus.OK);
	}
	
	
	@GetMapping("/{orderId}")
	public ResponseEntity<PaymentResponse> getPaymentDetails(@PathVariable Long orderId){
	   PaymentResponse paymentResponse=paymentService.getPaymentDetails(orderId);
		return new ResponseEntity<>(paymentResponse,HttpStatus.OK);
	}
}
