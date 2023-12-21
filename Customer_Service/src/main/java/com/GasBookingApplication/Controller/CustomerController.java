package com.GasBookingApplication.Controller;

import java.util.List;

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

import com.GasBookingApplication.CustomerException.CustomerNotFoundException;
import com.GasBookingApplication.Dto.CustomerDto;
import com.GasBookingApplication.Service.ICustomerService;

@RestController
@RequestMapping("/api")
public class CustomerController {

	@Autowired
	private ICustomerService customerService;

	@Autowired
	private ModelMapper modelMapper;

	@PostMapping("/customer")
	public ResponseEntity<CustomerDto> insertCustomer(@RequestBody CustomerDto customerDto) {
		return new ResponseEntity<>(customerService.insertCustomer(customerDto), HttpStatus.CREATED);

	}

	@PutMapping("/updatecustomer/{customerId}")
	public ResponseEntity<String> updateCustomer(@PathVariable int customerId, CustomerDto customerDto) {
		return ResponseEntity.ok(customerService.updateCustomer(customerId, customerDto));

	}

	@DeleteMapping("/deletecustomer/{customerId}")
	public ResponseEntity<String> deleteCustomer(@PathVariable int customerId) {
		return ResponseEntity.ok(customerService.deleteCustomer(customerId));

	}

	@GetMapping("/view")
	public ResponseEntity<List<CustomerDto>> viewCustomers() {
		try {
			List<CustomerDto> customerDtoList = customerService.viewCustomers();
			return new ResponseEntity<>(customerDtoList, HttpStatus.OK);
		} catch (CustomerNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/viewcustomer/{customerId}")
	public ResponseEntity<CustomerDto> viewCustomerById(@PathVariable int customerId) {
		if (isValidCustomerId(customerId)) {
			return ResponseEntity.ok(customerService.viewById(customerId));
		} else {
			return ResponseEntity.badRequest().build(); // You can customize the response accordingly

		}

	}

	private boolean isValidCustomerId(int customerId) {
		// Add your validation logic here
		// For example, check if customerId is positive or some other condition
		return customerId > 0;
	}

}