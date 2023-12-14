package com.gasbookingapplication.controller;

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

import com.gasbookingapplication.Service.GasBookingService;
import com.gasbookingapplication.dto.GasBookingDto;

@RestController
@RequestMapping("/api")
public class GasBookingController {
	@Autowired
	private GasBookingService gasbookingService;
	
	@PostMapping("/booking")
	public ResponseEntity<GasBookingDto>  insertGasBooking(@RequestBody GasBookingDto gasbookingDto){
		return new ResponseEntity<>(gasbookingService.insertGasBooking(gasbookingDto),HttpStatus.CREATED);
		
	}
	@PutMapping("/updatebooking/{bookingid}")
	public ResponseEntity<String> updateGasBooking(@PathVariable ("bookingid") int gasbookingId,@RequestBody GasBookingDto gasbookingDto){
		return ResponseEntity.ok(gasbookingService.updateGasBooking(gasbookingId, gasbookingDto));
		
	}
	@DeleteMapping("/deletebooking/{bookingid}")
	public ResponseEntity<String> deleteGasBooking(@PathVariable ("bookingid") int gasbookingId ){
		return ResponseEntity.ok(gasbookingService.deleteGasBooking(gasbookingId));
		
	}
	
	@GetMapping("/getBill/{customerId}")
	public ResponseEntity<GasBookingDto> getBill(@PathVariable("customerId") int customerId) {
		if (isValidCustomerId(customerId)) {
			return ResponseEntity.ok(gasbookingService.getBill(customerId));
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

	
	
	
	
	

	
