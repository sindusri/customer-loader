package com.ram.learn.controller;

import java.util.Collection;
import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@GET
	@RequestMapping(path = "/customers", produces={"application/json"},method = RequestMethod.GET)
	public Collection<Customer> getCustomers() {
	
		return customerService.getCustomers();
		
	}
	@RequestMapping(path = "/customer", consumes={"application/json"}, produces={"application/json"},method = RequestMethod.POST)
	public UUID createCustomer(@RequestBody Customer customer) {
	
		return customerService.createCustomer(customer);
		
	}
	
	@RequestMapping(path = "/customer/{id}", produces={"application/json"},method = RequestMethod.GET)
	public Customer getCustomer(@PathParam("id") UUID uuid) {
	
		return customerService.getCustomer(uuid);
		
	}
	/*@DELETE
	@RequestMapping("/customer/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Customer deleteCustomer(@PathParam("id") UUID uuid) {
	
		return customerService.getCustomer(uuid);
		
	}
	*/
	@RequestMapping(path = "/customer", consumes={"application/json"}, produces={"application/json"},method = RequestMethod.DELETE)
	public UUID updateCustomer(Customer customer) {
	
		return customerService.updateCustomer(customer);
		
	}
}
