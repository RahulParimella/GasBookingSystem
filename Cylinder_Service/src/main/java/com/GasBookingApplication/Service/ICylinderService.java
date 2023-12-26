package com.GasBookingApplication.Service;

import java.util.List;

import com.GasBookingApplication.Dto.CylinderDto;
import com.GasBookingApplication.Model.Cylinder;

public interface ICylinderService {

	CylinderDto insertCylinder(CylinderDto cylinderDto);
	
	String updateCylinder(int cylinderid,CylinderDto cylinderDto);
	
	String deleteCylinder(int cylinderid);
	
	List<Cylinder> viewCylinders();
	
	List<Cylinder> viewCylinderByType(String type);
	
	CylinderDto viewCylinderById(int cylinderid);

	
}
