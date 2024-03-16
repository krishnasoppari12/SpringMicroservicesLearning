package com.microservices1.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderRequest {

	private Long productId;
	private double amount;
	private int quantity;
	private PaymentMode paymentMode;
}
