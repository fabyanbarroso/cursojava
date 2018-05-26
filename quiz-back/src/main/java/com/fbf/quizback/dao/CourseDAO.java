package com.fbf.quizback.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.fbf.quizback.model.Course;

@Repository
public interface CourseDAO extends PagingAndSortingRepository<Course, Integer>{

}
