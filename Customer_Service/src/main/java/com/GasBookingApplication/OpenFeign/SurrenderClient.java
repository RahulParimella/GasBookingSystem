package com.GasBookingApplication.OpenFeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.GasBookingApplication.Dto.SurrenderCylinderDto;

@FeignClient(value="SURRENDERCYLINDER-MICROSERVICES",url= "http://localhost:8084/api")
public interface SurrenderClient {

	@GetMapping("/viewsurrenderdcylinder/{surrenderid}")
	public ResponseEntity<SurrenderCylinderDto> viewById(@PathVariable("surrenderid") int surrenderId);
}
