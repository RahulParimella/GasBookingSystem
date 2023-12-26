package com.gasbookingapplication.Service;

import com.gasbookingapplication.dto.GasBookingDto;

public interface GasBookingService {
	GasBookingDto insertGasBooking(GasBookingDto gasbookingDto);
	
	String updateGasBooking(int gasbookingId,GasBookingDto gasbookingDto);
	
	String deleteGasBooking(int gasbookingId);
	
	GasBookingDto getBill(int customerId);

	GasBookingDto viewGasBookingById(int customerId);
	

	


}