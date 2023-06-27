package com.akash.securityboilercode.config;

import org.springframework.security.core.Authentication;

public interface AuthenticationWrapperService {
	 Authentication getAuthentication();
}
