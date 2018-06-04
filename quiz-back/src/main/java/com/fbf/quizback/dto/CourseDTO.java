package com.fbf.quizback.dto;

import java.io.Serializable;
import java.sql.Date;

import lombok.Data;

@Data
public class CourseDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idCourse;
	private String name;
	private Date date;

}