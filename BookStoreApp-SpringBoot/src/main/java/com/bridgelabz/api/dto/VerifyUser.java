package com.bridgelabz.api.dto;

import lombok.Data;

@Data
public class VerifyUser {
	
	private String email_id;
	private int otp;
	
	public VerifyUser(String email_id, int OTP) {
		this.email_id = email_id;
		this.otp = OTP;
	}
}
