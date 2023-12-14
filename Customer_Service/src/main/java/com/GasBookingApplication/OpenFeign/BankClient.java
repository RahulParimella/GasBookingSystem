package com.GasBookingApplication.OpenFeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.GasBookingApplication.Dto.BankDto;

@FeignClient(name="BANK-MICROSERVICES",url="http://localhost:8082/api")
public interface BankClient {

	@GetMapping("/viewbank/{bankId}")
	public ResponseEntity<BankDto> viewById(@PathVariable("bankId") int bankId) ;
}
