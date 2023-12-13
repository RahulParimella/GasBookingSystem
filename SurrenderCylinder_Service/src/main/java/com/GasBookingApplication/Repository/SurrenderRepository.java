package com.GasBookingApplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.GasBookingApplication.model.SurrenderCylinder;
@Repository
public interface SurrenderRepository extends JpaRepository<SurrenderCylinder, Integer>{

}
