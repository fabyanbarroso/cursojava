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
    
    @ExceptionHandler(DificultNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorResponse handleDificultNotFoundException(final DificultNotFoundException ex) {
        log.error("Dificult not found thrown", ex);
        return new ErrorResponse("DIFICULT_NOT_FOUND", "The dificult was not found");
    }
    
    @ExceptionHandler(QuizUsedException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorResponse handleQuizUsedException(final QuizUsedException ex) {
        log.error("The quiz is assigned to a question", ex);
        return new ErrorResponse("DIFICULT_IN_USED", "The quiz is assigned to a question");
    }
    
    @ExceptionHandler(EmailUserDuplicated.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorResponse handleEmailUserDuplicated(final EmailUserDuplicated ex) {
        log.error("The quiz is assigned to a question", ex);
        return new ErrorResponse("EMAIL_IN_USED", "The email is used");
    }
    
    @ExceptionHandler(AnswerNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorResponse handleAnswerNotFoundException(final AnswerNotFoundException ex) {
        log.error("The answer not found thrown", ex);
        return new ErrorResponse("ANSWER_NOT_FUND", "The answer was not found");
    }
    
    @ExceptionHandler(TooManyAnswerException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorResponse handleTooManyAnswerException(final TooManyAnswerException ex) {
        log.error("Too many answer thrown", ex);
        return new ErrorResponse("TOO_MANY_ANSWER", "o more than 4 responses are allowed");
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