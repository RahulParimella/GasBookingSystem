package com.GasBookingApplication.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.GasBookingApplication.Model.Cylinder;
@Repository
public interface CylinderRepository extends JpaRepository<Cylinder, Integer>{

	List<Cylinder> findByType(String type);
	




	
}
