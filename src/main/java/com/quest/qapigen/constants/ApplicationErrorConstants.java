package com.quest.qapigen.constants;

import org.springframework.http.HttpStatus;

public class ApplicationErrorConstants {
	
	ApplicationErrorConstants(){}

	public static String ERRSTATUS400 = String.valueOf(HttpStatus.BAD_REQUEST.value());
	public static String ERRSTATUS500 = String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value());
}
