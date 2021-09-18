package com.bridgelabz.api.util;

import lombok.Data;

@Data
public class Response {
	
	private Integer statusCode;
	private String statusMessage;
	private Object token;
	public Response(Integer statusCode, String statusMessage, Object token) {
		this.statusCode = statusCode;
		this.statusMessage = statusMessage;
		this.token = token;
	}
	
	
	

}
