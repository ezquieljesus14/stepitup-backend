package com.ezjedev.stepitup.exceptions;

import org.springframework.http.HttpStatus;

public class BusinessException extends ApiException{

	private static final long serialVersionUID = 1L;

	public BusinessException( String message) {
		super(HttpStatus.CONFLICT, message);
	}

}
