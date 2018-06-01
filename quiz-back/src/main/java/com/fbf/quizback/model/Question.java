package com.fbf.quizback.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Question {
	
	public static final String FIELD_QUESTION = "question";
	public static final String FIELD_QUIZ = "quiz";
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int id_question;
	
	@Column(nullable = false)
	private String question;
	
	@ManyToMany
	@JoinTable(name = "Question_Quiz",
			   joinColumns = {@JoinColumn(name = FIELD_QUESTION)},
			   inverseJoinColumns = {@JoinColumn(name = FIELD_QUIZ)})
	private List<Quiz> quiz;
	
	@OneToOne
	@JoinColumn(name = "idDificultad")
	private Dificult dificult;
	
	@OneToMany(fetch = FetchType.LAZY)
	List<Answer> answer;
}
