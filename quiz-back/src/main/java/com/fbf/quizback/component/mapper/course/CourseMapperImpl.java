package com.fbf.quizback.component.mapper.course;

import org.springframework.stereotype.Component;

import com.fbf.quizback.component.mapper.AbstractMapper;
import com.fbf.quizback.dto.CourseDTO;
import com.fbf.quizback.model.Course;

@Component
public class CourseMapperImpl extends AbstractMapper<Course, CourseDTO> implements CourseMapper{

	@Override
	public Class<? extends CourseDTO> dtoClazz() {
		return CourseDTO.class;
	}

	@Override
	public Class<? extends Course> modelClazz() {
		return Course.class;
	}
}