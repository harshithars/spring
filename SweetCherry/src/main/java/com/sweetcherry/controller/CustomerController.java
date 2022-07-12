package com.sweetcherry.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sweetcherry.entity.Customer;
import com.sweetcherry.entity.CustomerDTO;
import com.sweetcherry.exception.CustomerNotFoundException;
import com.sweetcherry.exception.InvalidIdException;
import com.sweetcherry.services.CustomerService;

@RestController
@RequestMapping("/v1")
@CrossOrigin(value="http://localhost:3000/")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/customer")
	public Customer registerCustomer(@Valid @RequestBody CustomerDTO customerDTO) {
		Customer customer = new Customer(null, customerDTO.getCustomerName(), customerDTO.getEmail(),customerDTO.getMobileNumber(), customerDTO.getPassword(),customerDTO.getRegDate());
		return this.customerService.registerCustomer(customer);
	}
	
	@PutMapping("/customer")
	public Customer updateCustomerProfile(@RequestBody CustomerDTO customerDTO) throws CustomerNotFoundException {
		return this.customerService.updateCustomerProfile(customerDTO);
	}
	
	@GetMapping("/customers")
	public List<Customer> getAllCustomers(){
		return this.customerService.getAllCustomers();
	}
	
	@GetMapping("/customer/{id}")
	public Customer allCustomerDetailsById(@PathVariable("id") Integer customerId) throws InvalidIdException {
		return this.customerService.allCustomerDetailsById(customerId);
	}
	
	@DeleteMapping("/customer/{id}")
	   public Customer deleteCustomer(@PathVariable("id") int customerId)throws InvalidIdException {
	     return this.customerService.deleteCustomerById(customerId);
	}

}
