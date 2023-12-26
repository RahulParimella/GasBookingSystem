package com.GasBookingApplication.Service;

import com.GasBookingApplication.Dto.BankDto;

public interface IBankService {

	BankDto insertBank(BankDto bankDto);

	String deleteBank(int bankId);

	String updateBank(int bankId, BankDto bankDto);

	//List<Bank> viewBanks();

	BankDto viewById(int bankId);

}
