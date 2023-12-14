package com.GasBookingApplication.Service;

import java.util.List;

import com.GasBookingApplication.Dto.BankDto;
import com.GasBookingApplication.Model.Bank;


public interface IBankService {
	
	BankDto insertBank(BankDto bankDto);
	
	
	
	String deleteBank(int bankId);

	String updateBank(int bankId, BankDto bankDto);

	List<Bank> viewBanks();
	
	BankDto viewById(int bankId);
	
}
