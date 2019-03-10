/*
 * CustomerService.java
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

import com.ram.learn.model.Customer;

public interface CustomerService {

	public Collection<Customer> getCustomers();

	public Customer getCustomer(UUID uuid);

	public UUID createCustomer(Customer customer);

	public UUID deleteCustomer(UUID uuid);

	public UUID updateCustomer(UUID uuid,Customer customer);

}
