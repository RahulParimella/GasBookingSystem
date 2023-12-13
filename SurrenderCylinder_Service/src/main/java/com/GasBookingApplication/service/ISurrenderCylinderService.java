package com.GasBookingApplication.service;

import com.GasBookingApplication.dto.SurrenderCylinderDto;

public interface ISurrenderCylinderService {


	SurrenderCylinderDto insertSurrenderCylinder(SurrenderCylinderDto surrenderCylinderDto);
	
	String updateSurrenderCylinder(int surrenderId,SurrenderCylinderDto surrenderCylinderDto);
	
	String deleteSurrenderCylinder(int surrenderId);
	
	SurrenderCylinderDto viewById(int surrenderId);
	
}
