package com.fbf.quizback.dto;

import java.io.Serializable;

import lombok.Data;
@Data
public class QuizQuestionDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idQuiz;
	private int idQuestion;
}
