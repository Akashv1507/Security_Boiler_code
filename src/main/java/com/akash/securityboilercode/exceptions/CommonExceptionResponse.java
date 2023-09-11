package com.akash.securityboilercode.exceptions;


import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CommonExceptionResponse {

	private LocalDateTime timestamp;
	//private Date date;
	private String message;
	private String details;
}
