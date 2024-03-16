package com.microservices1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices1.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
