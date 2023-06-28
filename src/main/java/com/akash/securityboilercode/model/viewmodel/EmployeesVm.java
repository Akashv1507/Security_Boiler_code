package com.akash.securityboilercode.model.viewmodel;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class EmployeesVm {
	
	private long empId;
	private String email;
	private String name;
	private List<String> roles;

}
