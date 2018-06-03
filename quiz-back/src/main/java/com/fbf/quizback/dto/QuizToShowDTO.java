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

		private int idQuiz;
		private String nameQuiz;
		//private CourseDTO course;
		private List<QuestionToShowDTO> question;
}
