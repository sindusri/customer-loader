/*
 * CustomerServiceImpl.java
 *
 * Copyright (c) 2018 Southwest Airlines, Co.
 * 2702 Love Field Drive, Dallas, TX 75235, U.S.A.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Southwest Airlines, Co.
 *
 */
package com.ram.learn.service;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ram.learn.model.Order;
import com.ram.learn.repository.OrderRepository;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepository orderRepository;

	@Override
	public Collection<Order> getOrders() {
		return (Collection<Order>) orderRepository.findAll();
	}

	@Override
	public UUID createOrder(Order order) {
		UUID uuid = UUID.randomUUID();
		order.setId(uuid);
		orderRepository.save(order);
		return uuid;
	}

	@Override
	public UUID updateOrder(Order order) {
		Optional<Order> existingOrder = orderRepository.findById(order.getId());
		if (null != existingOrder.get()) {

			return existingOrder.get().getId();
		}
		return null;

	}

	@Override
	public Order getOrder(UUID orderId) {
		return orderRepository.findById(orderId).get();
	}

}
