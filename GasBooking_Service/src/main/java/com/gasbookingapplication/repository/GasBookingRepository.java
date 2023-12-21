package com.gasbookingapplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gasbookingapplication.dto.GasBookingDto;
import com.gasbookingapplication.model.GasBooking;

public interface GasBookingRepository extends JpaRepository<GasBooking, Integer> {


	List<GasBooking> save(List<GasBookingDto> gasbookingDtoList);

//	List<GasBookingDto> saveAll(List<GasBookingDto> students);


	
}
