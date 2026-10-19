package com.ezjedev.stepitup.dtos.api;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.annotation.Nonnull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponseDto<T> {

	private final LocalDateTime timestamp;
	private final String message;
	private final T data;
	
	private static final String DEFAULT_MESSAGE = "Operación exitosa";
	
	private ApiResponseDto(String message, T data ) {
		this.timestamp = LocalDateTime.now();
		this.message = message;
		this.data = data;
	}
	
	public static <T> ApiResponseDto<T> ok(T data) {
	    return ok(DEFAULT_MESSAGE, data);
	}

	public static <T> ApiResponseDto<T> ok(String message, T data) {
	    return new ApiResponseDto<>(message, data);
	}

	public static ApiResponseDto<Void> message(String message) {
	    return new ApiResponseDto<>(message, null);
	}
}
