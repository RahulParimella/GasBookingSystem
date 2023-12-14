package com.GasBookingApplication.Contoller;

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

import com.GasBookingApplication.Dto.BankDto;
import com.GasBookingApplication.Service.IBankService;

@RestController
@RequestMapping("/api")
public class BankController {
	
	@Autowired
	private IBankService bankService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@PostMapping("/bank")
	public ResponseEntity<BankDto> insertCylinder(@RequestBody BankDto bankDto) {
		
		 return new ResponseEntity<>(bankService.insertBank(bankDto), HttpStatus.CREATED);	
	
	}
	
	@PutMapping("/updatebank/{bankId}")
	public ResponseEntity<String> updateBank(@PathVariable int bankId,@RequestBody BankDto bankDto ){
		return ResponseEntity.ok(bankService.updateBank(bankId, bankDto));
	
		
	}
	
	@DeleteMapping("/deletebank/{bankId}")
	public ResponseEntity<String> deleteBank(@PathVariable int bankId ){
		
		return  ResponseEntity.ok(bankService.deleteBank(bankId));
		
	}
	
	@GetMapping("/viewbanks")
	//Type1
	public ResponseEntity<List<BankDto>> viewBanks(){
		
		return ResponseEntity.ok(bankService.viewBanks().stream()
				.map(bank->modelMapper.map(bank, BankDto.class))
				.collect(Collectors.toList()));
	}
	
	
	
	@GetMapping("/viewbank/{bankId}")
	public ResponseEntity<BankDto> viewById(@PathVariable("bankId") int bankId) {
		if (isValidBankId(bankId)) {
			return ResponseEntity.ok(bankService.viewById(bankId));
		} else {
			return ResponseEntity.badRequest().build(); // You can customize the response accordingly

		}

	}

	private boolean isValidBankId(int bankId) {
		// Add your validation logic here
		// For example, check if customerId is positive or some other condition
		return bankId > 0;
	}
	
}
