package com.GasBookingApplication.Service;

import java.util.List;

import com.GasBookingApplication.Dto.CustomerDto;
import com.GasBookingApplication.Model.Customer;

public interface ICustomerService {

	CustomerDto insertCustomer(CustomerDto customerDto);
	
	String updateCustomer(int customerId,CustomerDto customerDto);
	
	String deleteCustomer(int customerId);
	
	List<CustomerDto> viewCustomers();
	
	//List<Customer> viewCustomers();
	CustomerDto viewById(int customerId);
	
	
	
	
}