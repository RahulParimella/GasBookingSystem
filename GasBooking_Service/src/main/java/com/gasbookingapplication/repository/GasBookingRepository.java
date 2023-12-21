package com.gasbookingapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gasbookingapplication.model.GasBooking;

public interface GasBookingRepository extends JpaRepository<GasBooking, Integer> {

//	List<GasBookingDto> saveAll(List<GasBookingDto> students);


	
}
