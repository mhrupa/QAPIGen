package com.quest.qapigen.exceptions;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

/**
 * Contains details about the @Valid, @Responsebody error message details
 * 
 * @author RanjanRo
 *
 */
public class ValidationException extends RuntimeException {

	private static final long serialVersionUID = -5145669732673327484L;
	private final transient BindingResult errors;

	public ValidationException(BindingResult errors) {
		this.errors = errors;
	}

	public List<String> getMessages() {
		return getValidationMessage(this.errors);
	}

	@Override
	public String getMessage() {
		return this.getMessages().toString().trim();
	}

	// extract a message from the binging result
	public static List<String> getValidationMessage(BindingResult bindingResult) {
		return bindingResult.getAllErrors().stream().map(ValidationException::getValidationMessage).sorted()
				.collect(Collectors.toList());
	}

	public static String getValidationMessage(ObjectError error) {

		if (error instanceof FieldError) {
			FieldError fieldError = (FieldError) error;
			String property = fieldError.getField();
			String message = fieldError.getDefaultMessage();
			return String.format("%s %s", property, message);
		}

		return String.format("%s", error.getDefaultMessage());
	}

}
