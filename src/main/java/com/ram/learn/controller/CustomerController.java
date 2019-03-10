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

import com.ram.learn.model.Customer;
import com.ram.learn.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping(path = "/customers", produces = { "application/json" }, method = RequestMethod.GET)
	public Collection<Customer> getCustomers() {

		return customerService.getCustomers();

	}

	@RequestMapping(path = "/customer", consumes = { "application/json" }, produces = {
			"application/json" }, method = RequestMethod.POST)
	public UUID createCustomer(@RequestBody Customer customer) {

		return customerService.createCustomer(customer);

	}

	@RequestMapping(path = "/customer/{id}", produces = { "application/json" }, method = RequestMethod.GET)
	public Customer getCustomer(@PathVariable("id") String id) {

		try {
			UUID customerId = UUID.fromString(id);
			return customerService.getCustomer(customerId);
		} catch (IllegalArgumentException e) {

			return null;
		}

	}

	@RequestMapping(path = "/customer/{id}", consumes = { "application/json" }, produces = {
			"application/json" }, method = RequestMethod.PUT)
	public UUID updateCustomer(@PathVariable("id") String id, @RequestBody Customer customer) {
		UUID customerId = UUID.fromString(id);
		return customerService.updateCustomer(customerId,customer);
	}

	@RequestMapping(path = "/customer/{id}", produces = {
			"application/json" }, method = RequestMethod.DELETE)
	public UUID deleteCustomer(@PathVariable("id") String id) {
		UUID customerId = UUID.fromString(id);
		return customerService.deleteCustomer(customerId);

	}
}
