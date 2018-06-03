package com.fbf.quizback.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "The quiz is assigned to a question")
public class QuizUsedException extends Exception{

}
