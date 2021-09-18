package com.bridgelabz.api.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bridgelabz.api.dto.UserDTO;

import lombok.Data;

@Entity
@Table(name = "user_registration")
public @Data class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long user_id;
	
	private String first_name;
	
	private String last_name;
	
	private String kyc;
	
	private LocalDate birth_date;
	
	private LocalDateTime registration_date;
	
	private LocalDateTime update_date;
	
	private String password;
	
	private String email_id;
	
	private Boolean verify;
	
	private String otp;
	
	private LocalDate purchase_date;
	
	private LocalDate expiry_date;

	public User() {
	}
	

	public User(UserDTO user) {
		this.first_name = user.first_name;
		this.last_name = user.last_name;
		this.kyc = user.kyc;
		this.birth_date = user.birth_date;
		this.registration_date = user.registration_date;
		this.update_date = user.update_date;
		this.password = user.password;
		this.email_id = user.email_id;
		this.verify = user.verify;
		this.otp = user.otp;
		this.purchase_date = user.purchase_date;
		this.expiry_date = user.expiry_date;
	}

	

	public void updateUser(UserDTO user) {
		this.first_name = user.first_name;
		this.last_name = user.last_name;
		this.birth_date = user.birth_date;
		this.update_date = user.registration_date;
		this.email_id = user.email_id;
	}
}
