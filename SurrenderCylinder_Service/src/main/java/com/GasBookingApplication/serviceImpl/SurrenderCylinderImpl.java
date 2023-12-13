package com.GasBookingApplication.serviceImpl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.GasBookingApplication.Exception.SurrenderCylinderNotFoundException;
import com.GasBookingApplication.Repository.SurrenderRepository;
import com.GasBookingApplication.dto.CylinderDto;
import com.GasBookingApplication.dto.SurrenderCylinderDto;
import com.GasBookingApplication.model.SurrenderCylinder;
import com.GasBookingApplication.openFeign.CylinderClient;
import com.GasBookingApplication.service.ISurrenderCylinderService;

@Service
public class SurrenderCylinderImpl implements ISurrenderCylinderService{
	
	@Autowired
	private SurrenderRepository surrenderRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private CylinderClient cylinderClient;
	
//	@Autowired
//	private CustomerClient customerClient;
	
	@Override
	public SurrenderCylinderDto insertSurrenderCylinder(SurrenderCylinderDto surrenderCylinderDto) {
		// TODO Auto-generated method stub
		SurrenderCylinder surrenderCylinder = modelMapper.map(surrenderCylinderDto, SurrenderCylinder.class);
		SurrenderCylinder savedsurrenderCylinder=surrenderRepo.save(surrenderCylinder);
		SurrenderCylinderDto surrendercylinderDto1=modelMapper.map(savedsurrenderCylinder, SurrenderCylinderDto.class);
		return surrendercylinderDto1;
		
	}

	@Override
	public String updateSurrenderCylinder(int surrenderId, SurrenderCylinderDto surrenderCylinderDto) {
		// TODO Auto-generated method stub
		 Optional<SurrenderCylinder> optionalCylinder = surrenderRepo.findById(surrenderId);

	        if (optionalCylinder.isPresent()) {
	        	SurrenderCylinder existingsurrenderCylinder = optionalCylinder.get();
	        	existingsurrenderCylinder.setSurrenderDate(surrenderCylinderDto.getSurrenderDate());
	           
	        	surrenderRepo.save(existingsurrenderCylinder);
	            return "SurrenderCylinder with ID " + surrenderId + " updated successfully";
	        } else {
	            throw new SurrenderCylinderNotFoundException("Cylinder with ID " + surrenderId + " not found");
	        }
	}

	@Override
	public String deleteSurrenderCylinder(int surrenderId) {
		// TODO Auto-generated method stub
		Optional<SurrenderCylinder> c=surrenderRepo.findById(surrenderId);
		if(c.isPresent()) {
			
			surrenderRepo.delete(c.get());
			return "deleted successfully";
		}
		else {
			throw new SurrenderCylinderNotFoundException("Cylinder with"+surrenderId+ "not found");
		}
	}

	@Override
	public SurrenderCylinderDto viewById(int surrenderId) {
		// TODO Auto-generated method stub
		Optional<SurrenderCylinder> surrendercylinder =surrenderRepo.findById(surrenderId);
		if(surrendercylinder.isPresent()) {
			SurrenderCylinder c=surrendercylinder.get();
			SurrenderCylinderDto surrendercylinderDto =modelMapper.map(surrendercylinder, SurrenderCylinderDto.class);
			// for cylinder
						ResponseEntity<CylinderDto> cylinderResponseEntity =cylinderClient.viewById(surrenderId);
						CylinderDto cylDto =cylinderResponseEntity.getBody();
						surrendercylinderDto.setCylinderDto(cylDto);
						
			
						 //for customer
//						ResponseEntity<CustomerDto> customerResponseEntity =customerClient.viewCustomerById(surrenderId);
//						CustomerDto custDto =customerResponseEntity.getBody();
//						surrendercylinderDto.setCustomerDto(custDto);
			return surrendercylinderDto;

		}
		else {
			throw new SurrenderCylinderNotFoundException("surrenderId id not found:"+surrenderId);

		}
	}

}
