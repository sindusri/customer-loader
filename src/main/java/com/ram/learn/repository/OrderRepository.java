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

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.ram.learn.model.Order;

public interface OrderRepository extends CrudRepository<Order, UUID> {

}