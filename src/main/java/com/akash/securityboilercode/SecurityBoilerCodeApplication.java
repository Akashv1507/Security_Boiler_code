package com.akash.securityboilercode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//@EnableAutoConfiguration(exclude=DataSourceAutoConfiguration.class)
@SpringBootApplication
public class SecurityBoilerCodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityBoilerCodeApplication.class, args);
	}

}
