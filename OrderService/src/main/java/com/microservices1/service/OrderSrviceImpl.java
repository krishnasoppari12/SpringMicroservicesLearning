package com.microservices1.service;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices1.client.ProductService;
import com.microservices1.entity.Order;
import com.microservices1.model.OrderRequest;
import com.microservices1.repository.OrderRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OrderSrviceImpl implements OrderService{

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private ProductService productService;
	
	@Override
	public Long placeOrder(OrderRequest orderRequest) {
		
		log.info("Before Placing Order");
		
		productService.reduceQuantity(orderRequest.getProductId(),orderRequest.getQuantity());
		log.info("After Checking for product availability");
        Order order=Order.builder()
        		.productId(orderRequest.getProductId())
        		.price(orderRequest.getAmount())
        		.orderDate(Instant.now())
        		.orderStatus("CREATED")
        		.quantity(orderRequest.getQuantity())
        		.build();
        log.info("Order placed");
        order=orderRepository.save(order);
        log.info("Product Saved Successfully....!");
		return order.getOrderId();
	}

}
