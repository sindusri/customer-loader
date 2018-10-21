/*
 * CustomerController.java
 *
 * Copyright (c) 2018 Southwest Airlines, Co.
 * 2702 Love Field Drive, Dallas, TX 75235, U.S.A.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Southwest Airlines, Co.
 *
 */
package com.ram.learn.controller;

import java.util.Collection;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ram.learn.model.Order;
import com.ram.learn.service.OrderService;

@RestController
public class OrderController {

	@Autowired
	private OrderService orderService;

	@RequestMapping(path = "/orders", produces = { "application/json" }, method = RequestMethod.GET)
	public Collection<Order> getOrders() {
		return orderService.getOrders();

	}

	@RequestMapping(path = "/order", consumes = { "application/json" }, produces = {
			"application/json" }, method = RequestMethod.POST)
	public UUID createOrder(@RequestBody Order order) {

		return orderService.createOrder(order);

	}

	@RequestMapping(path = "/order/{id}", produces = { "application/json" }, method = RequestMethod.GET)
	public Order getOrder(@PathVariable("id") String id) {

		try {
			UUID orderId = UUID.fromString(id);
			return orderService.getOrder(orderId);
		} catch (IllegalArgumentException e) {

			return null;
		}

	}

	@RequestMapping(path = "/order", consumes = { "application/json" }, produces = {
			"application/json" }, method = RequestMethod.PUT)
	public UUID updateCustomer(Order order) {
		return orderService.updateOrder(order);
	}

}
