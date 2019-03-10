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

import com.ram.learn.model.Customer;
import com.ram.learn.model.GENDER;
import com.ram.learn.repository.CustomerRepository;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	@Override
	public Collection<Customer> getCustomers() {

		return (Collection<Customer>) customerRepository.findAll();
	}

	@Override
	public UUID createCustomer(Customer customer) {
		UUID uuid = UUID.randomUUID();
		customer.setId(uuid);
		if (null == customer.getGender()) {
			customer.setGender(GENDER.UNKNOWN);
		}
		customerRepository.save(customer);
		return uuid;
	}

	@Override
	public UUID updateCustomer(UUID customerId,Customer customer) {
		Optional<Customer> existingCustomer = customerRepository.findById(customerId);
		if (null != existingCustomer.get()) {
			existingCustomer.get().setFirstName(customer.getFirstName());
			existingCustomer.get().setLastName(customer.getLastName());
			existingCustomer.get().setBirthDate(customer.getBirthDate());
			customerRepository.save(existingCustomer.get());
			return existingCustomer.get().getId();
		}
		return null;

	}

	@Override
	public UUID deleteCustomer(UUID uuid) {
		customerRepository.deleteById(uuid);
		return uuid;
	}

	@Override
	public Customer getCustomer(UUID uuid) {
		return customerRepository.findById(uuid).get();

	}

}
