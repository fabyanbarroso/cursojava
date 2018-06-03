package com.fbf.quizback.dto;

import java.io.Serializable;

import com.fbf.quizback.model.Dificult;
import com.fbf.quizback.model.Tag;

import lombok.Data;

@Data
public class QuestionDTO implements Serializable{
	private String question;
	private Dificult dificultLevel;
	private Tag tagQuestion;
}
