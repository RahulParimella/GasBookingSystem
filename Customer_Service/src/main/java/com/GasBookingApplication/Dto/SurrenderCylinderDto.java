package com.GasBookingApplication.Dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;

public class SurrenderCylinderDto {

	private int surrenderId;
	
	  @NotNull(message = "Date cannot be null")
	private LocalDate surrenderDate;

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
