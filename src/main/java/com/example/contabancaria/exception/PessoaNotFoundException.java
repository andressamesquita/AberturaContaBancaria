package com.example.contabancaria.exception;

public class PessoaNotFoundException extends Exception {

	private static final long serialVersionUID = 6168584979282403534L;

	public PessoaNotFoundException() {
		super();
		
	}

	public PessoaNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public PessoaNotFoundException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public PessoaNotFoundException(String message) {
		super(message);
		
	}

	public PessoaNotFoundException(Throwable cause) {
		super(cause);
		
	}
	
	
}
