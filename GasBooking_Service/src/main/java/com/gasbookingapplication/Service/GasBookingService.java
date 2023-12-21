package com.gasbookingapplication.Service;

import java.util.List;

import com.gasbookingapplication.dto.GasBookingDto;

public interface GasBookingService {
	GasBookingDto insertGasBooking(GasBookingDto gasbookingDto);
	
	String updateGasBooking(int gasbookingId,GasBookingDto gasbookingDto);
	
	String deleteGasBooking(int gasbookingId);
	
	GasBookingDto getBill(int customerId);
	
	List<GasBookingDto> viewGasBookingById(int customerId);

//	List<GasBookingDto> addMultipleBookings(List<GasBookingDto> gasbookingDto);

}