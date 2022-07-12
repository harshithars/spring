package com.sweetcherry.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.sweetcherry.entity.Customer;
import com.sweetcherry.entity.CustomerDTO;
import com.sweetcherry.exception.CustomerNotFoundException;
import com.sweetcherry.exception.InvalidIdException;
import com.sweetcherry.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepo;
	
	@Override
	public Customer registerCustomer(@RequestBody Customer customer) {
		return this.customerRepo.save(customer);
	}

	@Override
	public Customer updateCustomerProfile(CustomerDTO customerDTO) throws CustomerNotFoundException {
		Optional<Customer> customerOpt = this.customerRepo.findById(customerDTO.getCustomerId());
		if(customerOpt.isEmpty())
			throw new CustomerNotFoundException("Customer id does not exist to update.");
		Customer updateCustomerProfile =customerOpt.get();
		updateCustomerProfile.setCustomerName(customerDTO.getCustomerName());
		updateCustomerProfile.setMobileNumber(customerDTO.getMobileNumber());
		updateCustomerProfile.setEmail(customerDTO.getEmail());
		updateCustomerProfile.setPassword(customerDTO.getPassword());
		return this.customerRepo.save(updateCustomerProfile);
	}

	@Override
	public Customer allCustomerDetailsById(int customerId) throws InvalidIdException {
		Optional<Customer> customerOpt= this.customerRepo.findById(customerId);
		if(customerOpt.isEmpty())
			throw new InvalidIdException("Id Not Found");
		return customerOpt.get();
	}

	@Override
	public List<Customer> getAllCustomers() {
		return this.customerRepo.findAll();
	}
	
	@Override
	public Customer deleteCustomerById(int customerId) throws InvalidIdException {
		Optional<Customer> optCustomer = this.customerRepo.findById(customerId);
		if(optCustomer.isEmpty())
			throw new InvalidIdException("Customer Id does not exists to delete.");
		this.customerRepo.deleteById(customerId);
		return optCustomer.get();	
	}

}
