package com.akash.securityboilercode.services;

import com.akash.securityboilercode.model.RegisterResult;
import com.akash.securityboilercode.model.RegistrationModel;

public interface LoginService {

	RegisterResult registerUser(RegistrationModel registraionData);

	
}
