package com.quest.qapigen.exceptions;

import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.quest.qapigen.constants.ApplicationErrorConstants;
import com.quest.qapigen.utils.DateUtils;

/**
 * It's a global exception handler class for all
 * 
 * @author GiduguSa
 * @since 1.0
 */
@PropertySource("classpath:/error_messages.properties")
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	public GlobalExceptionHandler() {
		super();
	}


	/**
	 * Handles validation exception
	 * 
	 * @param validation exception
	 * @return validation exception details
	 */
	@ExceptionHandler(ValidationException.class)
	public ResponseEntity<ErrorMessageDetails> handleValidationException(ValidationException exception) {
		ErrorMessageDetails errorResponse = new ErrorMessageDetails(DateUtils.getCurrentDateTime(),
				HttpStatus.BAD_REQUEST.value(), exception.getMessages(), ApplicationErrorConstants.ERRSTATUS400);

		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}
}