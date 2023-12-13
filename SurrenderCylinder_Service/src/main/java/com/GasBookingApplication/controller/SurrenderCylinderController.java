package com.GasBookingApplication.controller;

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

import com.GasBookingApplication.dto.SurrenderCylinderDto;
import com.GasBookingApplication.service.ISurrenderCylinderService;

@RestController
@RequestMapping("/api")
public class SurrenderCylinderController {
	
	@Autowired
	private ISurrenderCylinderService surrenderService;
	
	@PostMapping("/surrendercylinder")
	public ResponseEntity<SurrenderCylinderDto> insertSurrenderCylinder(@RequestBody SurrenderCylinderDto surrenderCylinderDto){
		
		return new ResponseEntity<>(surrenderService.insertSurrenderCylinder(surrenderCylinderDto),HttpStatus.CREATED);
		
	}
	

	@PutMapping("/updatesurrendercylinder/{surrenderid}")
	public ResponseEntity<String> updateSurrenderCylinder(@PathVariable int surrenderId ,SurrenderCylinderDto surrenderCylinderDto) {
		return ResponseEntity.ok(surrenderService.updateSurrenderCylinder(surrenderId, surrenderCylinderDto));
	}
	
	@DeleteMapping("/deletesurrendercylinder/{surrenderid}")
	public ResponseEntity<String> deleteSurrenderCylinder(@PathVariable int surrenderId) {
		
		return ResponseEntity.ok( surrenderService.deleteSurrenderCylinder(surrenderId));
	}
	@GetMapping("/viewsurrenderdcylinder/{surrenderid}")
	public ResponseEntity<SurrenderCylinderDto> viewById(@PathVariable("surrenderid") int surrenderId) {
		if (isValidSurrenderId(surrenderId)) {
			return ResponseEntity.ok(surrenderService.viewById(surrenderId));
		} else {
			return ResponseEntity.badRequest().build(); // You can customize the response accordingly

		}

	}

	private boolean isValidSurrenderId(int surrenderId) {
		// Add your validation logic here
		// For example, check if customerId is positive or some other condition
		return surrenderId > 0;
	}
}
