package com.akash.securityboilercode.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.akash.securityboilercode.model.RegisterResult;
import com.akash.securityboilercode.model.RegistrationModel;
import com.akash.securityboilercode.model.ResponseHandler;
import com.akash.securityboilercode.services.LoginService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class LoginController {

	private LoginService loginService;

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	@ResponseBody
	public String getRegistrationPage() {
		return "this is a registraion page";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Object> registerUser(@RequestBody RegistrationModel registrationData) {
		boolean isSuccess = true;
		RegisterResult result = loginService.registerUser(registrationData);
		
		if (result.getStatus().value()!=201) {
			isSuccess = false;
		}
		
		return ResponseHandler.generateResponse(result.getStatus(), isSuccess, result.getMsg(), result);
		

	}
}
