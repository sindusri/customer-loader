package com.ram.learn.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ram.learn.model.Customer;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
	
	private Map<UUID,Customer> customers = new HashMap<>();

	@Override
	public Collection<Customer> getCustomers() {
		
		return customers.values();
	}
	
	@Override
	public UUID createCustomer(Customer customer) {
		UUID uuid = UUID.randomUUID();
		customer.setId(uuid);
		 customers.put(UUID.randomUUID(), customer);
		return uuid;
	}
	
	@Override
	public UUID updateCustomer(Customer customer) {
		Customer existingCustomer = customers.get(customer.getId());
		if (null == existingCustomer){
			return null;
		}
		existingCustomer.setFirstName(customer.getFirstName());
		existingCustomer.setLastName(customer.getLastName());
		return customer.getId();
	}

	@Override
	public Customer deleteCustomer(UUID uuid) {
		return customers.remove(uuid);
		
	}

	@Override
	public Customer getCustomer(UUID uuid) {
		return customers.get(uuid);
	}

	

}
