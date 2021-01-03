package com.example.contabancaria.exception;

public class ContaResourceException extends Exception{

	
	private static final long serialVersionUID = -22656234639106000L;

	public ContaResourceException() {
		super();
		
	}

	public ContaResourceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public ContaResourceException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public ContaResourceException(String message) {
		super(message);
		
	}

	public ContaResourceException(Throwable cause) {
		super(cause);
		
	}

	
	
}