package com.GasBookingApplication.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "SurrenderCylinder_microservice")
public class SurrenderCylinder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int surrenderId;

	@Column(name="date")
	private LocalDate surrenderDate;

	public SurrenderCylinder() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SurrenderCylinder(int surrenderId, LocalDate surrenderDate) {
		super();
		this.surrenderId = surrenderId;
		this.surrenderDate = surrenderDate;
	}

	public int getSurrenderId() {
		return surrenderId;
	}

	public void setSurrenderId(int surrenderId) {
		this.surrenderId = surrenderId;
	}

	public LocalDate getSurrenderDate() {
		return surrenderDate;
	}

	public void setSurrenderDate(LocalDate surrenderDate) {
		this.surrenderDate = surrenderDate;
	}

}
