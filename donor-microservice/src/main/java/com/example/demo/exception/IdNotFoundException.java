package com.example.demo.exception;

public class IdNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4414266130918808222L;
	private String message;

	public IdNotFoundException(String message) {
		super(message);
		
	}

	@Override
	public String getMessage() {
		
		return "Exception :="+message;
	}
}
