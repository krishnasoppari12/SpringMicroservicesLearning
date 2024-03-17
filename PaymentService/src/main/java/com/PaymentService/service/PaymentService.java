package com.PaymentService.service;

import com.PaymentService.model.PaymentRequest;
import com.PaymentService.model.PaymentResponse;

public interface PaymentService {

	long doPayment(PaymentRequest paymentRequest);

	PaymentResponse getPaymentDetails(Long orderId);

}
