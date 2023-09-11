package com.akash.securityboilercode.services;

import com.akash.securityboilercode.entities.Employee;

public interface EmployeeService {

	public Employee getEmployee(Long id);
	public Employee updateEmployee(Employee emp);
	public void deleteEmployee(Long id);



}
