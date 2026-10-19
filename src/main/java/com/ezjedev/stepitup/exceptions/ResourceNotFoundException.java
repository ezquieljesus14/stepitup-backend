package com.ezjedev.stepitup.exceptions;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends ApiException{

	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException( String message) {
		super(HttpStatus.NOT_FOUND, message);
	}

}
