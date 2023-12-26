package com.GasBookingApplication.OpenFeign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.GasBookingApplication.Dto.CylinderDto;

@FeignClient(value = "CYLINDER-MICROSERVICES", url = "http://localhost:8083/api")
public interface CylinderClient {

	@GetMapping("/viewcylinder/{cylinderId}")
	public ResponseEntity<CylinderDto> viewById(@PathVariable("cylinderId") int cylinderId);

	@GetMapping("/viewcylinders")
	// Type1
	public ResponseEntity<List<CylinderDto>> viewCylinders();
}
