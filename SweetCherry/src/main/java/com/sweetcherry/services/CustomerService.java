package com.sweetcherry.services;

import java.util.List;

import com.sweetcherry.entity.Customer;
import com.sweetcherry.entity.CustomerDTO;
import com.sweetcherry.exception.CustomerNotFoundException;
import com.sweetcherry.exception.InvalidIdException;


public interface CustomerService {
	
	public Customer registerCustomer(Customer customer); 
	public Customer allCustomerDetailsById(int customerId) throws InvalidIdException;
	public Customer updateCustomerProfile(CustomerDTO customerDTO) throws CustomerNotFoundException;
	public List<Customer> getAllCustomers();
	public Customer deleteCustomerById(int customerid) throws InvalidIdException;

}
