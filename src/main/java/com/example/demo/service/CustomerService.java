package com.example.demo.service;

import java.util.Collection;
import java.util.UUID;

import com.example.demo.model.Customer;

public interface CustomerService {

	public Collection<Customer> getCustomers();
	public Customer getCustomer(UUID uuid);
	public UUID createCustomer(Customer customer);
	public Customer deleteCustomer(UUID uuid);
	public UUID updateCustomer(Customer customer);
	
}
