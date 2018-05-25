package com.allame.controller;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class HataController {

	
	
/*	@ExceptionHandler(Exception.class)
	public String hatalanFunc(){
		
		return "hatalan";
	}
	*/
	
	
	@ResponseStatus(value=HttpStatus.OK,reason = "IYIMI GARAÞ")
	@ExceptionHandler(Exception.class)
	public void handleIOException(){
		
		
	}
}
