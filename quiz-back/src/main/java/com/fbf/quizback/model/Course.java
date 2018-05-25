package com.fbf.quizback.model;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Course {

	@Id
	@GeneratedValue
	private int idCourse;
	
	@Column
	private Date date;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = Quiz.FIELD_COURSE)
	private List<Quiz> quizs;
}
