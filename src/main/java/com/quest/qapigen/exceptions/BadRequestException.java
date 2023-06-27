package com.quest.qapigen.exceptions;

/**
 * This is customized BadRequestException thrown when invalid request processed.
 * 
 * @author RanjanRo
 *
 */
public class BadRequestException extends BaseException {

	private static final long serialVersionUID = -1307493420921168255L;

	/**
	 * If the request did not contain valid data
	 */
	public static final String INVALID_REQUEST = "Invalid request. Reason: ";

	/**
	 * Default Constructor.
	 */
	public BadRequestException() {
		super(INVALID_REQUEST);
	}

	/**
	 * @param message
	 */
	public BadRequestException(String message) {
		super(INVALID_REQUEST + message);
	}

	/**
	 * @param errorCode
	 * @param message
	 */
	public BadRequestException(int errorCode, String message) {
		super(errorCode, INVALID_REQUEST + message);
	}
}