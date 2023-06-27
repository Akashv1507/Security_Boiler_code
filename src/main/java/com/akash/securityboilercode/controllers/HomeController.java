package com.akash.securityboilercode.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.akash.securityboilercode.config.AuthenticationWrapperService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class HomeController {
	
	private AuthenticationWrapperService authenticationWrapperService;
	
	@RequestMapping(value = {"/home", "/"}, method = RequestMethod.GET)
	
	public String getIndexPage(Model model) {
		 Authentication authentication = authenticationWrapperService.getAuthentication();
		 //authentication.getA
		 Boolean isAdminBoolean = authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN"));
		 model.addAttribute("authenticationDetails", authentication);
		 model.addAttribute("isAdminBoolean",isAdminBoolean);
		return "index";
	}
	

}
