package com.akash.securityboilercode.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akash.securityboilercode.repository.EmployeeRepository;


@RestController
public class ContactController {
	@Autowired
	EmployeeRepository repo;

	@GetMapping("/contact")
	public String contact() {
		return "this is a contact page";
	}

}
