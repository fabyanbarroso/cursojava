package com.fbf.quizback.dto;

import java.io.Serializable;
import lombok.Data;

@Data
public class QuestionPostDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String question;
	private int dificultLevel;
	//private int tagQuestion;
	//private int idQuiz;
}
