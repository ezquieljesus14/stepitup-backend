package com.ezjedev.stepitup.dtos.api;

import java.time.LocalDateTime;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiError {

	private final LocalDateTime timestamp;
	private final String message;
	private final Map<String, String> errors;

	private ApiError(String message, Map<String, String> errors) {
		this.timestamp = LocalDateTime.now();
		this.message = message;
		this.errors = errors;
	}

	public static ApiError of(String message) {
		return new ApiError(message, null);
	}

	public static ApiError of(String message, Map<String, String> errors) {
		return new ApiError(message, errors);
	}
}