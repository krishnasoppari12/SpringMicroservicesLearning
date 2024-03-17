package com.PaymentService.model;

	import java.time.Instant;

	import lombok.AllArgsConstructor;
	import lombok.Builder;
	import lombok.Data;
	import lombok.NoArgsConstructor;
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	@Builder
	public class PaymentResponse {
	  private long paymentId;
	  private long orderId;
	  private String status;
	  private PaymentMode paymentMode;
	  private double amount;
	  private Instant paymentDate;
	}


