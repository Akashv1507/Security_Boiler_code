package com.akash.securityboilercode.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.akash.securityboilercode.model.ResponseHandler;

@ControllerAdvice
public class UniversalControllerAdvice extends ResponseEntityExceptionHandler{

	@ExceptionHandler(EmployeeNotFoundException.class)
	public final ResponseEntity<Object> employeeNotFoundExceptionHandler(Exception ex, WebRequest request) {

		CommonExceptionResponse commonExceptionResponse = new CommonExceptionResponse(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));

		//return new ResponseEntity<CommonExceptionResponse>(commonExceptionResponse, HttpStatus.NOT_FOUND);
		return ResponseHandler.generateResponse(HttpStatus.NOT_FOUND, true, "Employee Not Found Exception Occured", commonExceptionResponse);
	}
}
