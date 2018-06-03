package com.fbf.quizback.dto;

import java.io.Serializable;
import lombok.Data;

@Data
public class QuestionDTO implements Serializable{
	private String question;
	private int dificultLevel;
	private int tagQuestion;
}
