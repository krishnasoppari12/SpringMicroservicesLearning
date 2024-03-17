package com.PaymentService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.PaymentService.entity.PaymentDetails;

@Repository
public interface PaymentRepo extends JpaRepository<PaymentDetails, Long>{

	PaymentDetails findByOrderId(Long orderId);

}
