package com.admin.util;

import java.io.Serializable;

public class GeneralResponse<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * The result data to response
	 */
	private T data;

	/**
	 * The result of operation
	 */
	private boolean success;

	/**
	 * The result message
	 */
	private String message;

	private Long rol;

	/**
	 * Constructor
	 */
	public GeneralResponse() {
	}

	/**
	 * Constructor
	 */
	public GeneralResponse(boolean success, String message, Long rol) {
		this.success = success;
		this.message = message;
		this.rol=rol;
	}

	/**
	 * Constructor
	 */
	public GeneralResponse(boolean success, String message, T data) {
		this.success = success;
		this.message = message;
		this.data = data;
	}

	/**
	 * Gets the data
	 * 
	 * @return the data value
	 */
	public T getData() {
		return data;
	}

	/**
	 * Gets the success
	 * 
	 * @return the success value
	 */
	public boolean isSuccess() {
		return success;
	}

	/**
	 * Gets the message
	 * 
	 * @return the message value
	 */
	
	
	public String getMessage() {
		return message;
	}

	public Long getRol() {
		return rol;
	}

	public void setRol(Long rol) {
		this.rol = rol;
	}

	/**
	 * Sets the data value
	 * 
	 * @param data the data to set
	 */
	public void setData(T data) {
		this.data = data;
	}

	/**
	 * Sets the success value
	 * 
	 * @param success the success to set
	 */
	public void setSuccess(boolean success) {
		this.success = success;
	}

	/**
	 * Sets the message value
	 * 
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return new com.google.gson.Gson().toJson(this);
	}

	
}
