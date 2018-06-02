package com.fbf.quizback.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Question not found")
public class QuestionNotFoundException extends Exception{


}
