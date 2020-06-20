package com.saeeds28.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestErrorAdvice {

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
}
