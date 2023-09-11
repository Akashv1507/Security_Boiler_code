package com.akash.securityboilercode.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.akash.securityboilercode.config.AuthenticationWrapperService;
import com.akash.securityboilercode.model.RegisterResult;
import com.akash.securityboilercode.model.RegistrationModel;
import com.akash.securityboilercode.model.ResponseHandler;
import com.akash.securityboilercode.services.LoginService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping(value = "/admin")
public class LoginController {

	private LoginService loginService;
	private AuthenticationWrapperService authenticationWrapperService;

	@RequestMapping(value = "/add/employee", method = RequestMethod.POST)
	public ResponseEntity<Object> registerUser(@ModelAttribute RegistrationModel registrationData) {
		boolean isSuccess = true;
		RegisterResult result = loginService.registerUser(registrationData);

		if (result.getStatus().value() != 201) {
			isSuccess = false;
		}
		return ResponseHandler.generateResponse(result.getStatus(), isSuccess, result.getMsg(), result);
		
	}

	@RequestMapping(value = "/add/employee", method = RequestMethod.GET)
	public String addEmpPage(Model model) {
		
		RegistrationModel registrationDataModel = new RegistrationModel();
		Authentication authentication = authenticationWrapperService.getAuthentication();
		List<String> roleStringsList = loginService.getRolesList();
		// authentication.getA
		model.addAttribute("authenticationDetails", authentication);
		model.addAttribute("registrationData", registrationDataModel);
		model.addAttribute("roleStringsList", roleStringsList);

		return "addEmp";

	}
}
