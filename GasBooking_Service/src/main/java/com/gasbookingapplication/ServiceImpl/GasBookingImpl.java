package com.gasbookingapplication.ServiceImpl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.gasbookingapplication.Exception.BookingNotFoundException;
import com.gasbookingapplication.Service.GasBookingService;
import com.gasbookingapplication.dto.CustomerDto;
import com.gasbookingapplication.dto.GasBookingDto;
import com.gasbookingapplication.model.GasBooking;
import com.gasbookingapplication.openfeign.CustomerClient;
import com.gasbookingapplication.repository.GasBookingRepository;

@Service
public class GasBookingImpl implements GasBookingService{

	@Autowired
	private GasBookingRepository bookingRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private CustomerClient customerClient;
	@Override
	public GasBookingDto insertGasBooking(GasBookingDto gasbookingDto) {
		// TODO Auto-generated method stub
		GasBooking gasBooking =modelMapper.map(gasbookingDto, GasBooking.class);
		GasBooking savedgasBooking=bookingRepo.save(gasBooking);
		GasBookingDto gasbookingDto1=modelMapper.map(savedgasBooking, GasBookingDto.class);
		return gasbookingDto1;
	}
	
	


	@Override
	public String updateGasBooking(int gasbookingId, GasBookingDto gasbookingDto) {
		// TODO Auto-generated method stub
		Optional<GasBooking> optionalgasbooking = bookingRepo.findById(gasbookingId);
		if(optionalgasbooking.isPresent()) {
			GasBooking existingbookings =optionalgasbooking.get();
			existingbookings.setBookingDate(gasbookingDto.getBookingDate());
			existingbookings.setBill(gasbookingDto.getBill());
			existingbookings.setStatus(false);
			bookingRepo.save(existingbookings);
			
			 return "booking with ID " + gasbookingId + " updated successfully";
        } else {
            throw new BookingNotFoundException("Cylinder with ID " + gasbookingId + " not found");
        }
	}

	@Override
	public String deleteGasBooking(int gasbookingId) {
		// TODO Auto-generated method stub
		 Optional<GasBooking> deletebookings = bookingRepo.findById(gasbookingId);
		 if(deletebookings.isPresent()) {
			 bookingRepo.delete(deletebookings.get());
			 return "booking deleted successfully";
		 }
		 else {
			 throw new BookingNotFoundException("booking with"+gasbookingId+ "not found");
		 }
		
	}

	@Override
	public GasBookingDto getBill(int customerId) {
		// TODO Auto-generated method stub
		Optional<GasBooking> gasbookings =bookingRepo.findById(customerId);
		if(gasbookings.isPresent()) {
			GasBooking gb=gasbookings.get();
			GasBookingDto gasbookingDto =modelMapper.map(gasbookings, GasBookingDto.class);
		
			// for customer
			ResponseEntity<CustomerDto> customerResponseEntity =customerClient.viewCustomerById(customerId);
			CustomerDto custDto =customerResponseEntity.getBody();
			gasbookingDto.setCustomerDto(custDto);
			return gasbookingDto;

		}
		else {
			throw new BookingNotFoundException("booking id not found:"+customerId);

		}
	}



	@Override
	public List<GasBookingDto> viewGasBookingById(int customerId) {
		// TODO Auto-generated method stub
		Optional<GasBooking> bookings =bookingRepo.findById(customerId);
		if(bookings.isPresent()) {
			GasBooking b=bookings.get();
			GasBookingDto gasbookingDto =modelMapper.map(bookings, GasBookingDto.class);
		
			// for customer
//						ResponseEntity<CustomerDto> customerResponseEntity =customerClient.viewCustomerById(customerId);
//						CustomerDto custDto =customerResponseEntity.getBody();
//						gasbookingDto.setCustomerDto(custDto);
			
			return  Collections.singletonList(gasbookingDto);
		

		}
		else {
			throw new BookingNotFoundException("Customer id not found:"+customerId);

		}
	}




	@Override
	public List<GasBookingDto> viewAll() {
		// TODO Auto-generated method stub
		List<GasBooking> list=bookingRepo.findAll();
		return list.stream().map(bookings->modelMapper.map(list, GasBookingDto.class)).collect(Collectors.toList());
	}

	

//	@Override
//	public List<GasBookingDto> addMultipleBookings(List<GasBookingDto> gasbookingDtoList) {
//	    // Assuming GasBookingDto is mapped to GasBooking by modelMapper
//	    List<GasBooking> gasBookings = gasbookingDtoList.stream()
//	            .map(dto -> modelMapper.map(dto, GasBooking.class))
//	            .collect(Collectors.toList());
//
//	    List<GasBooking> savedBookings = bookingRepo.saveAll(gasBookings);
//
//	    // Map the saved entities back to DTOs
//	    List<GasBookingDto> savedBookingsDto = savedBookings.stream()
//	            .map(booking -> modelMapper.map(booking, GasBookingDto.class))
//	            .collect(Collectors.toList());
//
//	    return savedBookingsDto;
//	}


	
	
	
}