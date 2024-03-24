package com.csis3275.group11.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csis3275.group11.model.Customer;

@Service
public class CustomerDAO 
{
	@Autowired
	private CustomerRepository customerRepository;
	
	public Customer createCustomer(Customer newCustomer)
	{
		return customerRepository.save(newCustomer);
	}
	
	public List<Customer> listAllCustomers()
	{
		return (List<Customer>)customerRepository.findAll();
	}
}
