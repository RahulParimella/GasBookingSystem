package com.GasBookingApplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.GasBookingApplication.Dto.BankDto;
import com.GasBookingApplication.Model.Bank;

public interface BankRepository extends JpaRepository<Bank, Integer>  {

	void save(BankDto bankDto1);

	

	
}
