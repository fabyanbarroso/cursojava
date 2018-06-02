package com.fbf.quizback.service;

import java.util.Iterator;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fbf.quizback.dao.QuizDAO;
import com.fbf.quizback.exception.QuestionNotFoundException;
import com.fbf.quizback.exception.QuizNotFoundException;
import com.fbf.quizback.model.Question;
import com.fbf.quizback.model.Quiz;

@Service
public class QuizServiceImpl implements QuizService{

	@Autowired
	QuizDAO quizDAO;
	
	@Autowired
	CourseService courseService;
	
	@Autowired
	QuestionService questionService;
	
	@Override
	public Quiz create(Quiz t, int idCourse) {
		// TODO Auto-generated method stub
		if (courseService.findById(idCourse).isPresent()) {
			t.setCourse(courseService.findById(idCourse).get());
		}
		return quizDAO.save(t);
	}

	@Override
	public void update(Quiz t) {
		// TODO Auto-generated method stub
		quizDAO.save(t);
	}

	@Override
	public Optional<Quiz> findById(Integer id) {
		// TODO Auto-generated method stub
		return quizDAO.findById(id);
	}

	@Override
	public Set<Quiz> findAll(Pageable p) {
		// TODO Auto-generated method stub
		int page = p.getPageNumber();
		int size = p.getPageSize();
		return quizDAO.findAll(PageRequest.of(page, size)).stream().collect(Collectors.toSet());
	}

	@Override
	public void delete(Quiz t) {
		// TODO Auto-generated method stub
		quizDAO.delete(t);
	}

	@Override
	public Set<Question> quizFindQuestion(int idQuiz) throws QuestionNotFoundException, QuizNotFoundException {
		// TODO Auto-generated method stub
		if(!quizDAO.findById(idQuiz).isPresent())
			throw new QuizNotFoundException();
		Quiz quiz = quizDAO.findById(idQuiz).get();
		Set <Question> questions = questionService.findAll(PageRequest.of(0, 10));
		
		
		
		return questions;
	}

}
