package com.akash.securityboilercode.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class RegistrationModel {

	private long empId;
	private String email;
	private String name;
	private String password;
	private List<String> roles;

}
