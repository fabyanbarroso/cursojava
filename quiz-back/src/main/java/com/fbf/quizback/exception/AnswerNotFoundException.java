package com.fbf.quizback.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Answer not found")
public class AnswerNotFoundException extends Exception{

}
