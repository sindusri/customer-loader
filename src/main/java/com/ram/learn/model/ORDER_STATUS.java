/*
 * ORDER_STATUS.java
 *
 * Copyright (c) 2018 Southwest Airlines, Co.
 * 2702 Love Field Drive, Dallas, TX 75235, U.S.A.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Southwest Airlines, Co.
 *
 */
package com.ram.learn.model;

public enum ORDER_STATUS {
	NEW, INPROGRESS, SHIPPED, DELIVERED;
	public ORDER_STATUS getOrderStatus(String status) {
		return ORDER_STATUS.valueOf(status);
	}
}
