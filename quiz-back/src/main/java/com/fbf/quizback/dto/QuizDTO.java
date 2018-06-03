package com.fbf.quizback.dto;

import java.io.Serializable;
import lombok.Data;

@Data
public class QuizDTO implements Serializable{
	private int id_quiz;
	private String name;

}
