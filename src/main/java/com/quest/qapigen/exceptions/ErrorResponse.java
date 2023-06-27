/**
 *
 */
package com.quest.qapigen.exceptions;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * This class will be used to build the error responses. It will contain error
 * codes as well as error description.
 *
 */
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorResponse implements Serializable{

	private static final long serialVersionUID = 2405172041950251807L;
    /**
     * This will represent the error code i.e Standard HTTP Codes. Default error
     * code = 500
     */
    private int errorCode = 500;
    /**
     * This will represent the error description
     */
    private String errorDescr;
    /**
     * @return the errorDescr
     */

    /**
     * Detail on the reson for the error code
     */
    private int reasonCode;

    public String getErrorDescr() {
        return errorDescr;
    }

    /**
     * @param errorDescr
     *            the errorDescr to set
     */
    public void setErrorDescr(String errorDescr) {
        this.errorDescr = errorDescr;
    }

    /**
     * @return the errorCode
     */
    public int getErrorCode() {
        return errorCode;
    }

    /**
     * @param errorCode
     *            the errorCode to set
     */
    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * @return the errorCode
     */
    public int getReasonCode() {
        return reasonCode;
    }

    /**
     * @param errorCode
     *            the errorCode to set
     */
    public void setReasonCode(int reasonCode) {
        this.reasonCode = reasonCode;
    }

    /**
     * @param errorCode
     * @param errorDescr
     */
    public ErrorResponse(int errorCode, String errorDescr) {
        super();
        this.errorCode = errorCode;
        this.errorDescr = errorDescr;
    }

    /**
     * @param errorCode
     * @param errorDescr
     */
    public ErrorResponse(int errorCode, String errorDescr, int reasonCode) {
        super();
        this.errorCode = errorCode;
        this.errorDescr = errorDescr;
        this.reasonCode = reasonCode;
    }

    /**
     *
     */
    public ErrorResponse() {
        super();
    }

    /**
     * @param errorMessage
     */
    public ErrorResponse(String errorDescr) {
        super();
        this.errorDescr = errorDescr;
    }
}
