package com.fbf.quizback.controller;

import java.util.Optional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
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
	public List<CourseDTO> findAll(@RequestParam(defaultValue = "0", required = false) Integer page,
			@RequestParam(defaultValue = "10", required = false) Integer size) {
		final List<Course> course = courseService.findAll(PageRequest.of(page, size));
		return courseMapper.modelToDto(course);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public CourseDTO findById(@PathVariable("id") Integer id) {
		final Optional<Course> course = courseService.findById(id);
		return courseMapper.modelToDto(course.get());
	}

	@RequestMapping(method = RequestMethod.POST)
	public CourseDTO create(@RequestBody CourseDTO dto) {
		final Course course = courseMapper.dtoToModel(dto);
		final Course createCourse = courseService.create(course);
		return courseMapper.modelToDto(createCourse);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void update(@PathVariable("id") Integer id, @RequestBody CourseDTO dto) {
		final Optional<Course> course = courseService.findById(id);
		Course courseEdit = courseMapper.dtoToModel(dto);
		course.get().setName(courseEdit.getName());
		course.get().setDate(courseEdit.getDate());
		courseService.update(course.get());
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Integer id) {
		final Optional<Course> course = courseService.findById(id);
		courseService.delete(course.get());
	}
}