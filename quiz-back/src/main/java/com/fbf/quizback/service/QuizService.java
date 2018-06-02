package com.fbf.quizback.service;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.domain.Pageable;

import com.fbf.quizback.exception.QuestionNotFoundException;
import com.fbf.quizback.exception.QuizNotFoundException;
import com.fbf.quizback.model.Question;
import com.fbf.quizback.model.Quiz;

public interface QuizService {
	Quiz create(Quiz t, int idCourse);
	
	void update(Quiz t);
	
	Optional<Quiz> findById(Integer id);
	
	Set<Quiz> findAll(Pageable p);
	
	void delete(Quiz t);
	
	Set<Question> quizFindQuestion(int idQuiz) throws QuestionNotFoundException, QuizNotFoundException;
	
}
