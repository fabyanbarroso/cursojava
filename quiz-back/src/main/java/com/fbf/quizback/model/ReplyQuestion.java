package com.fbf.quizback.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class ReplyQuestion {

	public static final String FIELD_USER = "user";	
	public static final String FIELD_QUIZ = "quiz";	
	
	@Id
	@GeneratedValue
	private int idReplyQuestion;
	
	@JoinColumn(name=FIELD_USER)
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;
	
	@JoinColumn(name=FIELD_QUIZ)
	@ManyToOne(fetch = FetchType.LAZY)
	private Quiz quiz;
	
	@OneToOne
	@JoinColumn(name = "idQuestion")
	private Question question;
	
	@OneToOne
	@JoinColumn(name = "idAnswer")
	private Answer answer;
}
