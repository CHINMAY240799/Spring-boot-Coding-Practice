package com.practice.employee.exception;

import java.time.LocalDateTime;

public record ErrorResponse (

		LocalDateTime timestamp, // when the error occurred.

		int status , //the numeric HTTP status code (e.g., 404).

		String error,// short HTTP reason phrase (e.g., "Not Found").

		String message, //. your specific exception message (e.g., "Employee not found with ID: 99").

		String path// the request URI that failed (e.g., "/api/employee/99").	
		

){
	public ErrorResponse() {
		
			this(LocalDateTime.now(), 0, null, null, null);

		
	}
	
	
}
