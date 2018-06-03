package com.fbf.quizback.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class QuestionToShowDTO implements Serializable{
	
	private int idQuestion;
	private String question;
	//private String tag;
	//private int dificult; 
}
