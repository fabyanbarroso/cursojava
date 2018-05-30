package com.fbf.quizback.model;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Course {

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int idCourse;
	
	@Column
	private Date date;
	
	@Column
	private String name;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = Quiz.FIELD_COURSE)
	private List<Quiz> quizs;
}
