package com.fbf.quizback.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;

import com.fbf.quizback.exception.QuestionNotFoundException;
import com.fbf.quizback.exception.QuizNotFoundException;
import com.fbf.quizback.model.Question;
import com.fbf.quizback.model.Quiz;

public interface QuizService {
	Quiz create(Quiz t);
	
	void update(Quiz t);
	
	Optional<Quiz> findById(Integer id);
	
	List<Quiz> findAll(Pageable p);
	
	void delete(Quiz t);
	
	List<Question> quizFindQuestion(int idQuiz) throws QuestionNotFoundException, QuizNotFoundException;
	
	public void addQuestion(Quiz quiz, int idQuestion) throws QuestionNotFoundException;

	void deleteQuestionQuiz(Quiz quiz, int idQuestion) throws QuizNotFoundException;
}
