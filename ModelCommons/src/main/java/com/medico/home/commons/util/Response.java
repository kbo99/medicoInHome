package com.medico.home.commons.util;

public class Response implements java.io.Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 4844776363199986069L;

	private String title;
	
	private String message;
	
	private String msError;
	
	private Object response;
	
	private String typeMessage;


	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the response
	 */
	public Object getResponse() {
		return response;
	}

	/**
	 * @param response the response to set
	 */
	public void setResponse(Object response) {
		this.response = response;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the typeMessage
	 */
	public String getTypeMessage() {
		return typeMessage;
	}

	/**
	 * @param typeMessage the typeMessage to set
	 */
	public void setTypeMessage(String typeMessage) {
		this.typeMessage = typeMessage;
	}

	public void setTypeMessage(IconAlert iconAlert) {
		this.typeMessage = iconAlert.getValue();
	}

	public String getMsError() {
		return msError;
	}

	public void setMsError(String msError) {
		this.msError = msError;
	}
}
