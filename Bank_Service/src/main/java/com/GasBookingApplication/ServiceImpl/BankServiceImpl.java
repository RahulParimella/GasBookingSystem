package com.GasBookingApplication.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.GasBookingApplication.BankException.BankNotFoundException;
import com.GasBookingApplication.Dto.BankDto;
import com.GasBookingApplication.Model.Bank;
import com.GasBookingApplication.Repository.BankRepository;
import com.GasBookingApplication.Service.IBankService;

@Service
public class BankServiceImpl implements IBankService{

	
	
	@Autowired
	private BankRepository bankRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public BankDto insertBank(BankDto bankDto) {
		// TODO Auto-generated method stub
		Bank bank =modelMapper.map(bankDto, Bank.class);
		Bank savedBank =bankRepo.save(bank);
		BankDto bankDto1=modelMapper.map(savedBank, BankDto.class);
		
		return bankDto1;
	}
	@Override
	public String updateBank(@PathVariable int bankId, @RequestBody BankDto bankDto) {
		// TODO Auto-generated method stub
		Optional<Bank> cy =bankRepo.findById(bankId);
		if(cy.isPresent()) {
			Bank updateBank =cy.get();
			//updateCylinder.setCylinderid(cylinder.getCylinderid());
			updateBank.setBankName(bankDto.getBankName());
			updateBank.setAddress(bankDto.getAddress());
			
			bankRepo.save(updateBank);
			return "updated Successfully";
	}
		else {
			throw new BankNotFoundException("Bank id not found:"+bankId);
		}
	}

	@Override
	public String deleteBank(int bankId) {
		// TODO Auto-generated method stub
		Optional<Bank> c=bankRepo.findById(bankId);
		if(c.isPresent()) {
			
			bankRepo.delete(c.get());
			return "deleted successfully";
		}
		else {
			throw new BankNotFoundException("Bank id not found:"+bankId);
		}
	}
	
	@Override
	public List<Bank> viewBanks() {
		// TODO Auto-generated method stub
		List<Bank> cylinders=bankRepo.findAll();
		if(cylinders.isEmpty()) {
			throw new BankNotFoundException("hey list is empty");
		}
		return cylinders;
	}
	@Override
	public BankDto viewById(int bankId) {
		// TODO Auto-generated method stub
		Optional<Bank> bank =bankRepo.findById(bankId);
		if(bank.isPresent()) {
			Bank c=bank.get();
			BankDto bankDto =modelMapper.map(bank, BankDto.class);
		
			return bankDto;

		}
		else {
			throw new BankNotFoundException("Bank id not found:"+bankId);

		}
	}

	

}
