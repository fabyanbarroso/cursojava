package com.fbf.quizback.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fbf.quizback.component.mapper.course.CourseMapper;
import com.fbf.quizback.dto.CourseDTO;
import com.fbf.quizback.model.Course;
import com.fbf.quizback.service.CourseService;



@RestController
@RequestMapping(value = "/course")
public class CourseController {

	@Autowired
	CourseService courseService;

	@Autowired
	CourseMapper courseMapper;

	@RequestMapping(method = RequestMethod.GET)
	public Set<CourseDTO> findAll(@RequestParam(defaultValue = "0", required = false) Integer page,
			@RequestParam(defaultValue = "10", required = false) Integer size) {
		final Set<Course> course = courseService.findAll(PageRequest.of(page, size));
		return courseMapper.modelToDto(course);
	}

	@RequestMapping(method = RequestMethod.POST)
	public CourseDTO create(@RequestBody CourseDTO dto) {
		final Course course = courseMapper.dtoToModel(dto);
		final Course createCourse = courseService.create(course);
		return courseMapper.modelToDto(createCourse);
	}

}