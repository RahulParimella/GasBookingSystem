package com.gasbookingapplication.openfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.gasbookingapplication.dto.CustomerDto;

@FeignClient(value="BOOKING-MICROSERVICES",url= "http://localhost:8081/api")

public interface CustomerClient {
	@GetMapping("/viewcustomer/{customerId}")
	public ResponseEntity<CustomerDto> viewCustomerById(@PathVariable int customerId);
}
