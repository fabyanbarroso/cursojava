package com.fbf.quizback.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Question {
	
	public static final String FIELD_QUESTION = "question";

	@Id
	@GeneratedValue
	private int idQuestion;
	
	@Column(nullable = false)
	private String question;
	
	@ManyToMany
	@JoinTable(name = "Question_Quiz",
			   joinColumns = {@JoinColumn(name = "idQuestion")},
			   inverseJoinColumns = {@JoinColumn(name = "idQuiz")})
	private List<Quiz> quiz;
	
	
}
