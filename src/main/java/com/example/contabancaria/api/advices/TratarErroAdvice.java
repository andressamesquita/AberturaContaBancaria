package com.example.contabancaria.api.advices;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratarErroAdvice {

	@Autowired
	private MessageSource messageSource;

	@ExceptionHandler
	public ResponseEntity<Map<String, String>> tratarErroMethodArgumentNotValidException(
			MethodArgumentNotValidException exception) {

		List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();

		Map<String, String> hashMap = new HashMap<String, String>();
		fieldErrors.forEach(error -> {
			String errorMessage = obterMensagemDeErro(error);
			hashMap.put(error.getField(), errorMessage);
		});

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(hashMap);
	}
	
	@ExceptionHandler
	public ResponseEntity<Map<String, String>> tratarErroHttpMessageNotReadableException(
			HttpMessageNotReadableException exception) {

		String message = exception.getMessage();

		Map<String, String> hashMap = new HashMap<String, String>();

		hashMap.put("mensagem-invalida", message);

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(hashMap);
	}
	
	

	@ExceptionHandler
	public ResponseEntity<Map<String, String>> tratarErroIllegalArgumentException(
			IllegalArgumentException exception) {

		String message = exception.getMessage();

		Map<String, String> hashMap = new HashMap<String, String>();

		hashMap.put("campo-duplicado", message);

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(hashMap);
	}
	
	
	private String obterMensagemDeErro(ObjectError error) {
		return messageSource.getMessage(error, LocaleContextHolder.getLocale());
	}

}
