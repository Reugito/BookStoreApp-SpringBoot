package com.bridgelabz.api.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

public @Data class UserDTO {
	
	public String first_name;
	
	public String last_name;
	
	public String kyc;
	
	@JsonFormat(pattern="dd-MM-yyyy")
	public LocalDate birth_date;
	
	public LocalDateTime registration_date = LocalDateTime.now();;
	
	public LocalDateTime update_date;
	
	public String password;
	
	public String email_id;
	
	public Boolean verify;
	
	public String otp;
	
	public LocalDate purchase_date;
	
	public LocalDate expiry_date;
}
