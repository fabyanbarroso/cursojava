package com.fbf.quizback.dto;

import java.io.Serializable;
import java.util.List;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class QuizToShowDTO implements Serializable{

		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private int idQuiz;
		private String nameQuiz;
		private List<QuestionToShowDTO> question;
}
