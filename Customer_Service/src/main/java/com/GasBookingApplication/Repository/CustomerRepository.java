package com.GasBookingApplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.GasBookingApplication.Dto.CustomerDto;
import com.GasBookingApplication.Model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	void save(CustomerDto customerDto1);
	//List<Customer> findById(int customerId);
}
