package com.ezjedev.stepitup.exceptions;

import org.springframework.http.HttpStatus;

public class DuplicateResourceException extends ApiException{

	private static final long serialVersionUID = 1L;

	public DuplicateResourceException( String message) {
		super(HttpStatus.CONFLICT, message);
	}

}
