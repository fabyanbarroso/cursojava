package com.fbf.quizback.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Email already exist")
public class EmailUserDuplicated extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
