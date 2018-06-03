package com.fbf.quizback.dto;

import java.io.Serializable;
import lombok.Data;

@Data
public class QuestionPostDTO extends QuestionDTO implements Serializable{
	private int idQuiz;
}
