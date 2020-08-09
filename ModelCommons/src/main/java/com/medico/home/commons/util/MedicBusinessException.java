package com.medico.home.commons.util;

/**
 * 
 * @author kbo99
 *
 */
public class MedicBusinessException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1065200140557641943L;

	private String errorCode;

	private String errorMessage;
	
	// Constructors	
	public MedicBusinessException() {
		super();
	}

	public MedicBusinessException(String errorCode, String errorMessage) {
		super(errorMessage);
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
	
	public MedicBusinessException(String errorCode, String errorMessage, Throwable e) {
		super(errorMessage, e);
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
	
	public MedicBusinessException(Throwable e) {
		super(e);
	}

	// Get and Setter
	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	
}
