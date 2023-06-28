package com.akash.securityboilercode.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.akash.securityboilercode.config.AuthenticationWrapperService;
import com.akash.securityboilercode.entities.Employee;
import com.akash.securityboilercode.model.viewmodel.EmployeesVm;
import com.akash.securityboilercode.repository.EmployeeRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Controller
@RequestMapping(value = "/admin")
@AllArgsConstructor
public class AdminController {
	
	private AuthenticationWrapperService authenticationWrapperService;
	private EmployeeRepository employeeRepository;
	
	
	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	
	public String getAllEmployees(Model model) {
		ArrayList<EmployeesVm> employeesVm = new ArrayList<EmployeesVm>();
		Authentication authentication = authenticationWrapperService.getAuthentication();
		List<Employee> employees = employeeRepository.findAll();
		
		for ( Employee emp : employees) {
			List<String> empRoleStrings = new ArrayList<String>();
			emp.getEmpRoles().stream().forEach(empRole-> empRoleStrings.add(empRole.getRoleName()));
			employeesVm.add(new EmployeesVm(emp.getEmpId(), emp.getEmail(), emp.getName(), empRoleStrings));
		}
		//employees.stream().map(emp->employeesVms.add(new EmployeesVm(emp.getEmpId(), emp.getEmail(), emp.getName(), )));
		 //authentication.getA 
		 model.addAttribute("authenticationDetails", authentication);
		 model.addAttribute("employeesVm",employeesVm);
		 
		return "admin/employees";
	}
}
