package com.akash.securityboilercode.services.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.akash.securityboilercode.entities.Employee;
import com.akash.securityboilercode.exceptions.EmployeeNotFoundException;
import com.akash.securityboilercode.repository.EmployeeRepository;
import com.akash.securityboilercode.repository.RoleRepository;
import com.akash.securityboilercode.services.EmployeeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmplyeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;
	private RoleRepository roleRepository;
	private PasswordEncoder passwordEncoder;
	@Override
	public Employee getEmployee(Long id) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee  does not exist "));
		return employee;
	}

	@Override
	public Employee updateEmployee(Employee emp) {

		Employee employee = employeeRepository.findById(emp.getId())
				.orElseThrow(() -> new EmployeeNotFoundException("Employee does not exist "));
		employee.setEmail(emp.getEmail());
		employee.setEmpId(emp.getEmpId());
		employee.setName(emp.getName());
		Employee savedEmp=employeeRepository.save(employee);

		return savedEmp;
	}

	@Override
	public void deleteEmployee(Long id) {
		employeeRepository.deleteById(id);
	}

}
