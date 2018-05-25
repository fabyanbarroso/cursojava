package com.fbf.quizback.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Tag {
	
	public static final String FIELD_QUIZ = "quiz";
	
	@Id
	@GeneratedValue
	private int idTag;
	
	@Column
	private String name;
	
	@ManyToMany
	@JoinTable(name = "Taq_Quiz",
			   joinColumns = {@JoinColumn(name = "idTag")},
			   inverseJoinColumns = {@JoinColumn(name = "idQuiz")})
	private List<Quiz> quiz;
	
	@OneToMany(fetch = FetchType.LAZY)
	private List<Question> questions;
}
	
