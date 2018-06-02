package com.fbf.quizback.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@ControllerAdvice(basePackages= {"com.fbf.quizback.fabian"})
@Slf4j
public class ExceptionHandlers {
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorResponse handleUserNotFoundException(final UserNotFoundException ex) {
        log.error("User not found thrown", ex);
        return new ErrorResponse("USER_NOT_FOUND", "The user was not found");
    }
    
    @ExceptionHandler(QuestionNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorResponse handleQuestionNotFoundException(final QuestionNotFoundException ex) {
        log.error("Question not found thrown", ex);
        return new ErrorResponse("QUESTION_NOT_FOUND", "The question was not found");
    }
    
    @ExceptionHandler(QuizNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorResponse handleQuizNotFoundException(final QuizNotFoundException ex) {
        log.error("Quiz not found thrown", ex);
        return new ErrorResponse("QUIZ_NOT_FOUND", "The quiz was not found");
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Throwable.class)
    @ResponseBody
    public ErrorResponse handleThrowable(final Throwable ex) {
      log.error("Unexpected error", ex);
      return new ErrorResponse("INTERNAL_SERVER_ERROR", "An unexpected internal server error occured");
    }
    
    

    @Data
    public static class ErrorResponse {
        private final String code;
        private final String message;
    }
}