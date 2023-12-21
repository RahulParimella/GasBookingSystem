package com.GasBookingApplication.OpenFeign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.GasBookingApplication.Dto.GasBookingDto;

@FeignClient(name="BOOKING-MICROSERVICES",url="http://localhost:8085/api")

public interface BookingClient {
	@GetMapping("/viewbookings/{customerId}")
	//Type1
	public ResponseEntity<List<GasBookingDto>> viewGasBookingById(@PathVariable int customerId);
}