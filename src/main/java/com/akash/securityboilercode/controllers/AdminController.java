package com.akash.securityboilercode.controllers;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.akash.securityboilercode.config.AuthenticationWrapperService;
import com.akash.securityboilercode.entities.Employee;
import com.akash.securityboilercode.repository.EmployeeRepository;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping(value = "/admin")
@AllArgsConstructor
public class AdminController {
	
	private AuthenticationWrapperService authenticationWrapperService;
	private EmployeeRepository employeeRepository;
	
	
	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public String getAllEmployees(Model model) {
		Authentication authentication = authenticationWrapperService.getAuthentication();
		List<Employee> employees = employeeRepository.findAll();
		 //authentication.getA 
		 model.addAttribute("authenticationDetails", authentication);
		 
		return "admin/employees";
	}
}
