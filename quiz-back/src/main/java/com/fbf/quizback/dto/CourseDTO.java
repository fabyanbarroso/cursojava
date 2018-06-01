package com.fbf.quizback.dto;
import java.io.Serializable;
import java.sql.Date;

import lombok.Data;

@Data
public class CourseDTO implements Serializable{

	private Integer idCourse;
	String name;
	private Date date;

}