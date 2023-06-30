package com.quest.qapigen.exceptions;

import java.util.List;

import com.quest.qapigen.constants.ErrorConstants;

/**
 * Custom exceptions thrown during validation
 *
 */
public class BaseException extends Exception {

    private static final long serialVersionUID = -97489601876868146L;

    public ErrorMessageDetails errorMessageDetails;
    
    public ErrorResponse error;

    /**
     *
     * @param errorMessage
     */
    public BaseException(String errorMessage) {
        super(errorMessage);
        this.error = new ErrorResponse(errorMessage);
    }

    /**
     * @param errorMessage
     */
    public BaseException(int errorCode, String errorMessage) {
        super(errorMessage);
        this.error = new ErrorResponse(errorCode, errorMessage);
    }

    /**
     *
     * @param errorMessage
     * @param cause
     */
    public BaseException(String errorMessage, Throwable cause) {
        super(errorMessage, cause);
        this.error = new ErrorResponse(errorMessage);
    }

    /**
     * Default Constructor
     */
    public BaseException() {
        super();
        this.error = new ErrorResponse(ErrorConstants.INTERNAL_SERVER_ERROR);
    }
    /**
     * 
     * @param message
     * @param cause
     * @param enableSuppression
     * @param writableStackTrace
     */
    public BaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.error = new ErrorResponse(message);
    }

    /**
     * 
     * @param cause
     */
    public BaseException(Throwable cause) {
        super(cause);
        this.error = new ErrorResponse(ErrorConstants.INTERNAL_SERVER_ERROR);
    }
    
    public BaseException(String timestamp,int statusCode,List<String> messages,String details) {
        this.errorMessageDetails = new ErrorMessageDetails(timestamp, statusCode, messages, details);
    }

}
