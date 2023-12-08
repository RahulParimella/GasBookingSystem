package com.GasBookingApplication.Controller;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.GasBookingApplication.Dto.CustomerDto;
import com.GasBookingApplication.Model.Customer;
import com.GasBookingApplication.Service.ICustomerService;

@RestController
@RequestMapping("/api")
public class CustomerController {
	
	@Autowired
	private ICustomerService customerService;
	

	@Autowired
	private ModelMapper modelMapper;
	
	@PostMapping("/customer")
	public ResponseEntity<CustomerDto> insertCustomer(@RequestBody CustomerDto customerDto){
		return new ResponseEntity<>(customerService.insertCustomer(customerDto),HttpStatus.CREATED);
		
	}
	
	@PutMapping("/updatecustomer/{customerId}")
	public ResponseEntity<String> updateCustomer(@PathVariable int customerId,CustomerDto customerDto){
		return ResponseEntity.ok(customerService.updateCustomer(customerId, customerDto));
		
	}
	
	@DeleteMapping("/deletecustomer/{customerId}")
	public ResponseEntity<String> deleteCustomer(@PathVariable int customerId,Customer customer){
		return ResponseEntity.ok(customerService.deleteCustomer(customerId, customer));
		
	}
	
	@GetMapping("/viewcustomers")
	//Type1
	public ResponseEntity<List<CustomerDto>> viewCustomers(){
		
		return ResponseEntity.ok(customerService.viewCustomers().stream()
				.map(customer->modelMapper.map(customer, CustomerDto.class))
				.collect(Collectors.toList()));
	}
	

	@GetMapping("/viewcustomer/{customerId}")
	public ResponseEntity<List<CustomerDto>> viewCustomerById(@PathVariable int customerId){
	    if (isValidCustomerId(customerId)) {
	    	return ResponseEntity.ok(customerService.findById(customerId).stream()
					.map(customer->modelMapper.map(customer, CustomerDto.class))
					.collect(Collectors.toList()));
			}else {
		        return ResponseEntity.badRequest().body(Collections.emptyList()); // You can customize the response accordingly

			}

	}

	private boolean isValidCustomerId(int customerId) {
	    // Add your validation logic here
	    // For example, check if customerId is positive or some other condition
	    return customerId > 0;
	}

}
