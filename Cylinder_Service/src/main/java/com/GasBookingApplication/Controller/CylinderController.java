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

import com.GasBookingApplication.Dto.CylinderDto;
import com.GasBookingApplication.Service.ICylinderService;

@RestController
@RequestMapping("/api")
public class CylinderController {

	@Autowired
	private ICylinderService Cylinderservice;
	
	
	@Autowired
	private ModelMapper modelMapper;
	
	@PostMapping("/cylinder")
	public ResponseEntity<CylinderDto> insertCylinder(@RequestBody CylinderDto cylinderDto) {
		
		 return new ResponseEntity<>(Cylinderservice.insertCylinder(cylinderDto), HttpStatus.CREATED);	
	
	}
	

	@PutMapping("/updatecylinder/{cylinderid}")
	public ResponseEntity<String> updateCylinder(@PathVariable int cylinderid ,@RequestBody CylinderDto cylinderDto) {
		return ResponseEntity.ok(Cylinderservice.updateCylinder(cylinderid, cylinderDto));
	}
	

	@GetMapping("/viewcylinders")
	//Type1
	public ResponseEntity<List<CylinderDto>> viewCylinders(){
		
		return ResponseEntity.ok(Cylinderservice.viewCylinders().stream()
				.map(cylinder->modelMapper.map(cylinder, CylinderDto.class))
				.collect(Collectors.toList()));
	}
	

	@GetMapping("/viewcylinders/{type}")
	//Type1
	public ResponseEntity<List<CylinderDto>> viewCylinderByType(@PathVariable String type){
		if (isValidType(type)) {
		return ResponseEntity.ok(Cylinderservice.viewCylinderByType(type).stream()
				.map(cylinder->modelMapper.map(cylinder, CylinderDto.class))
				.collect(Collectors.toList()));
		}else {
	        return ResponseEntity.badRequest().body(Collections.emptyList()); // You can customize the response accordingly

		}
		
	}
	
	private boolean isValidType(String type) {
	    // Add your condition for a valid 'type' here
	    // For example, check if it's not null and not empty
	    return type != null && !type.isEmpty();
	}
	
	@DeleteMapping("/cylinder/{cylinderid}")
	public ResponseEntity<String> deleteCylinder(@PathVariable int cylinderid) {
		
		return ResponseEntity.ok( Cylinderservice.deleteCylinder(cylinderid));
	}
	
	@GetMapping("/viewcylinder/{cylinderId}")
	public ResponseEntity<CylinderDto> viewById(@PathVariable("cylinderId") int cylinderId) {
		if (isValidCylinderId(cylinderId)) {
			return ResponseEntity.ok(Cylinderservice.viewCylinderById(cylinderId));
		} else {
			return ResponseEntity.badRequest().build(); // You can customize the response accordingly

		}

	}

	private boolean isValidCylinderId(int cylinderId) {
		// Add your validation logic here
		// For example, check if customerId is positive or some other condition
		return cylinderId > 0;
	}
}

