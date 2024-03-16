package com.microservices1.service;

import org.springframework.stereotype.Service;
import com.microservices1.model.OrderRequest;

@Service
public interface OrderService {

	public Long placeOrder(OrderRequest orderRequest);
}
