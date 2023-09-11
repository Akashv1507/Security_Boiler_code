package com.akash.securityboilercode.services;

import java.util.List;

import com.akash.securityboilercode.model.RegisterResult;
import com.akash.securityboilercode.model.RegistrationModel;

public interface LoginService {

	public RegisterResult registerUser(RegistrationModel registraionData);
	public List<String> getRolesList();

}
