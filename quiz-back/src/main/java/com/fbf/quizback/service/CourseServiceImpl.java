package com.fbf.quizback.service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.fbf.quizback.dao.CourseDAO;
import com.fbf.quizback.model.Course;

public class CourseServiceImpl implements CourseService{
	@Autowired
	CourseDAO courseDao;
	
	@Override
	public Course create(Course t) {
		// TODO Auto-generated method stub
		return courseDao.save(t);
	}

	@Override
	public void update(Course t) {
		// TODO Auto-generated method stub
		courseDao.save(t);
	}

	@Override
	public Optional<Course> findById(Integer id) {
		// TODO Auto-generated method stub
		return courseDao.findById(id);
	}

	@Override
	public Set<Course> findAll(Pageable p) {
		// TODO Auto-generated method stub
		int page = p.getPageNumber();
		int size = p.getPageSize();
		return courseDao.findAll(PageRequest.of(page, size)).stream().collect(Collectors.toSet());
	}

	@Override
	public void delete(Course t) {
		// TODO Auto-generated method stub
		courseDao.delete(t);	
	}
}

