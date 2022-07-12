package com.sweetcherry.entity;

import java.time.LocalDate;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class CustomerDTO {
	
	private Integer customerId;
	
	@NotNull(message = "Name cannot be null")
	@Size(min = 3, message = "Customer name should be of min 3 chars")
	private String customerName;
	
	@Email(message = "Email should be valid")
	private String email;
	
	@Pattern(regexp = "^[0-9]{10}$",message = "Mobile number must be of 10 digits")
	private String mobileNumber;
	
	@Size(min = 8, message = "Password should have min 8 chars")
	private String password;
	private LocalDate regDate;
	public CustomerDTO() {
		super();
	}
	public CustomerDTO(Integer customerId, String customerName, String email, String mobileNumber, String password,
			LocalDate regDate) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.password = password;
		this.regDate = regDate;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LocalDate getRegDate() {
		return regDate;
	}
	public void setRegDate(LocalDate regDate) {
		this.regDate = regDate;
	}
	
}
