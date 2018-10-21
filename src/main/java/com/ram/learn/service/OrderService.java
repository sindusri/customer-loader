/*
 * OrderService.java
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
import java.util.UUID;

import com.ram.learn.model.Order;

public interface OrderService {

	Collection<Order> getOrders();

	UUID createOrder(Order order);

	Order getOrder(UUID orderId);

	UUID updateOrder(Order order);

}
