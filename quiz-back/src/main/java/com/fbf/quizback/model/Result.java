package com.fbf.quizback.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Result {
	
	public static final String FIELD_QUIZ = "quiz";
	public static final String FIELD_USER = "user";
	
	@Id
	@GeneratedValue
	private int idResult;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
	@Column
	private float calification;
	
	@OneToMany(fetch = FetchType.LAZY)
	private User user;
	
	@JoinColumn(name=FIELD_QUIZ)
	@ManyToOne(fetch = FetchType.LAZY)
	private List<Quiz> quizs ;
}
