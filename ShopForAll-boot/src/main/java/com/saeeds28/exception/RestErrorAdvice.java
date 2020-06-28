package com.saeeds28.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice		// Global exception handling
public class RestErrorAdvice {

	// Specific exception
	@ExceptionHandler(value = ResourceNotFoundException.class)
	public ResponseEntity<CustomErrorResponse> notFound(ResourceNotFoundException e) {
		CustomErrorResponse exception = new CustomErrorResponse("NOT_FOUND", e.getMessage());
		exception.setTimestamp(LocalDateTime.now());
		exception.setStatus((HttpStatus.NOT_FOUND.value()));
		return new ResponseEntity<>(exception, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = BadRequestException.class)
	public ResponseEntity<CustomErrorResponse> badRequest(BadRequestException e) {
		CustomErrorResponse exception = new CustomErrorResponse("NOT_FOUND", e.getMessage());
		exception.setTimestamp(LocalDateTime.now());
		exception.setStatus((HttpStatus.BAD_REQUEST.value()));
		return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
	}
	
	// catch-all
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<CustomErrorResponse> ServerSideError(Exception e) {
		CustomErrorResponse exception = new CustomErrorResponse("SERVER_ERROR", e.getMessage());
		exception.setTimestamp(LocalDateTime.now());
		exception.setStatus((HttpStatus.INTERNAL_SERVER_ERROR.value()));
		return new ResponseEntity<>(exception, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
