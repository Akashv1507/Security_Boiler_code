package com.akash.securityboilercode.model;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class RegisterResult {
	private String msg;
	private HttpStatus status; 
}
