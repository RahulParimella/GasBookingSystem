package com.GasBookingApplication.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GasBookingApplication.CylinderException.CylinderNotFoundException;
import com.GasBookingApplication.Dto.CylinderDto;
import com.GasBookingApplication.Model.Cylinder;
import com.GasBookingApplication.Repository.CylinderRepository;
import com.GasBookingApplication.Service.ICylinderService;

@Service
public class CylinderServiceImpl implements ICylinderService {

	@Autowired
	private CylinderRepository cylinderRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	
//	@Override
	public CylinderDto insertCylinder(CylinderDto cylinderDto) {
		// TODO Auto-generated method stub
		Cylinder cylinder =modelMapper.map(cylinderDto, Cylinder.class);
		Cylinder savedCylinder=cylinderRepo.save(cylinder);
		CylinderDto cylinderDto1=modelMapper.map(savedCylinder, CylinderDto.class);
		
		return cylinderDto1;
	}
	
	
	
	 @Override
	    public String updateCylinder(int cylinderid, CylinderDto cylinderDto) {
	        Optional<Cylinder> optionalCylinder = cylinderRepo.findById(cylinderid);

	        if (optionalCylinder.isPresent()) {
	            Cylinder existingCylinder = optionalCylinder.get();
	            existingCylinder.setPrice(cylinderDto.getPrice());
	            existingCylinder.setStrapColor(cylinderDto.getStrapColor());
	            existingCylinder.setType(cylinderDto.getType());
	            existingCylinder.setWeight(cylinderDto.getWeight());
	            cylinderRepo.save(existingCylinder);
	            return "Cylinder with ID " + cylinderid + " updated successfully";
	        } else {
	            throw new CylinderNotFoundException("Cylinder with ID " + cylinderid + " not found");
	        }
	    }

	@Override
	public String deleteCylinder(int cylinderid) {
		// TODO Auto-generated method stub
		Optional<Cylinder> c=cylinderRepo.findById(cylinderid);
		if(c.isPresent()) {
			
			cylinderRepo.delete(c.get());
			return "deleted successfully";
		}
		else {
			throw new CylinderNotFoundException("Cylinder with"+cylinderid+ "not found");
		}
	}

	@Override
	public List<Cylinder> viewCylinders() {
		// TODO Auto-generated method stub
		List<Cylinder> cylinders=cylinderRepo.findAll();
		if(cylinders.isEmpty()) {
			throw new CylinderNotFoundException("hey list is empty");
		}
		return cylinders;
	}

	@Override
	public List<Cylinder> viewCylinderByType(String type) {
		// TODO Auto-generated method stub
		List<Cylinder> cy =cylinderRepo.findByType(type);
		
		if(cy.isEmpty()) {
			throw new CylinderNotFoundException("there is no such type");
		}
		return cy;
	}



	@Override
	public CylinderDto viewCylinderById(int cylinderid) {
		// TODO Auto-generated method stub
		Optional<Cylinder> cylinder =cylinderRepo.findById(cylinderid);
		if(cylinder.isPresent()) {
			Cylinder c=cylinder.get();
			CylinderDto cylinderDto =modelMapper.map(cylinder, CylinderDto.class);
		
			
			return cylinderDto;

		}
		else {
			throw new CylinderNotFoundException("Cylinder id not found:"+cylinderid);

		}
	}

	

	

	

}
