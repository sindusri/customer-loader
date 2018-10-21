/*
 * CustomerRepository.java
 *
 * Copyright (c) 2018 Southwest Airlines, Co.
 * 2702 Love Field Drive, Dallas, TX 75235, U.S.A.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Southwest Airlines, Co.
 *
 */
package com.ram.learn.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.ram.learn.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, UUID> {

	List<Customer> findByLastName(String lastName);
}