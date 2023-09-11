package com.akash.securityboilercode.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.akash.securityboilercode.config.AuthenticationWrapperService;
import com.akash.securityboilercode.entities.Employee;
import com.akash.securityboilercode.repository.EmployeeRepository;
import com.akash.securityboilercode.services.EmployeeService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping(value = "/admin")
public class EmployeesController {

	private AuthenticationWrapperService authenticationWrapperService;
	private EmployeeService employeeService;


	@RequestMapping(value = "/update/employees/{id}", method = RequestMethod.GET)
	public String getEmpUpdatePage(@PathVariable("id") Long id, ModelMap model) {
		Authentication authentication = authenticationWrapperService.getAuthentication();
		 //authentication.getA
		model.addAttribute("authenticationDetails", authentication);
		Employee employee = employeeService.getEmployee(id);
		model.addAttribute("emp", employee);
		return "empUpdate";
	}

	@RequestMapping(value = "/update/employees/{id}", method = RequestMethod.POST)
	public String updateEmp(@PathVariable("id") Long id, @ModelAttribute Employee emp) {

		Employee savedEmployee =employeeService.updateEmployee(emp);
		return "redirect:/admin/employees";
	}

	@RequestMapping(value = "/delete/employees/{id}", method = RequestMethod.GET)
	public String deleteEmp(@PathVariable("id") Long id) {


		employeeService.deleteEmployee(id);

		return "redirect:/admin/employees";
	}


}
