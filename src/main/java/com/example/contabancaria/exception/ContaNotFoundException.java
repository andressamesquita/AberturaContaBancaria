package com.example.contabancaria.exception;

public class ContaNotFoundException extends Exception{

	
	private static final long serialVersionUID = -4831539459085578288L;

	public ContaNotFoundException() {
		super();
		
	}

	public ContaNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public ContaNotFoundException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public ContaNotFoundException(String message) {
		super(message);
		
	}

	public ContaNotFoundException(Throwable cause) {
		super(cause);
		
	}

	

}
