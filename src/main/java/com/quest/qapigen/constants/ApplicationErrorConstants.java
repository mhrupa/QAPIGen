package com.quest.qapigen.constants;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class ApplicationErrorConstants {

	public static String ERRSTATUS400;
	public static String ERRSTATUS500;
	
	@PostConstruct
	public void init() {
		ApplicationErrorConstants.ERRSTATUS400 = String.valueOf(HttpStatus.BAD_REQUEST.value());
		ApplicationErrorConstants.ERRSTATUS500 = String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
