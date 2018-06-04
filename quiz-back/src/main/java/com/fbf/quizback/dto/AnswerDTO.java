package com.fbf.quizback.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class AnswerDTO implements Serializable{

	private int idAnswer;
	private String answer;
	private Boolean correct;
}
