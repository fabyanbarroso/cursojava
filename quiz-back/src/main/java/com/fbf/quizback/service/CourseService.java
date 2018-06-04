package com.fbf.quizback.service;

import com.fbf.quizback.exception.QuizNotFoundException;
import com.fbf.quizback.model.Course;

public interface CourseService extends AbstractCRUDService<Course, Integer> {

	void addQuiz(Course course, int idQuiz) throws QuizNotFoundException;

}
