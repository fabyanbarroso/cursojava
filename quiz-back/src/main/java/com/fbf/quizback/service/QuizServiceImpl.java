package com.fbf.quizback.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fbf.quizback.dao.QuizDAO;
import com.fbf.quizback.exception.QuestionNotFoundException;
import com.fbf.quizback.exception.QuizNotFoundException;
import com.fbf.quizback.exception.QuizUsedException;
import com.fbf.quizback.model.Question;
import com.fbf.quizback.model.Quiz;

import ch.qos.logback.core.joran.conditional.IfAction;

@Service
public class QuizServiceImpl implements QuizService{

	@Autowired
	QuizDAO quizDAO;
	
	@Autowired
	CourseService courseService;
	
	@Autowired
	QuestionService questionService;
	
	@Override
	public Quiz create(Quiz t) {
		// TODO Auto-generated method stub
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
	public List<Quiz> findAll(Pageable p) {
		// TODO Auto-generated method stub
		int page = p.getPageNumber();
		int size = p.getPageSize();
		return quizDAO.findAll(PageRequest.of(page, size)).stream().collect(Collectors.toList());
	}

	@Override
	public void delete(Quiz t) {
		quizDAO.delete(t);
	}

	@Override
	public List<Question> quizFindQuestion(int idQuiz) throws QuestionNotFoundException, QuizNotFoundException {
		// TODO Auto-generated method stub
		if(!quizDAO.findById(idQuiz).isPresent())
			throw new QuizNotFoundException();
		Quiz quizSelected = quizDAO.findById(idQuiz).get();
		
		final Iterable<Question> findAll = questionService.findAll(PageRequest.of(0, 10));
		final List<Question> res = new ArrayList<>();
		findAll.forEach(b -> {
			
			final Iterable<Quiz> findQuizInQuestion = b.getQuiz();
			findQuizInQuestion.forEach(a ->{
				if(quizSelected.equals(a))
					res.add(b);
			});
		});
		return res;
	}
	
	@Override
	public void deleteQuestionQuiz(Quiz quiz, int idQuestion) throws QuizNotFoundException {

		Optional<Quiz> quizSearch = quizDAO.findById(quiz.getId_quiz());
		if(!quizSearch.isPresent())
			throw new QuizNotFoundException();
	
		Quiz q = quizSearch.get();
		Optional<Question> question = questionService.findById(idQuestion);
		q.getQuestions().remove(question.get());
		question.get().getQuiz().remove(q);
		quizDAO.save(q);
	}
	
	@Override
	public void addQuestion(Quiz quiz, int idQuestion) throws QuestionNotFoundException {
		if(!questionService.findById(idQuestion).isPresent()) 
			throw new QuestionNotFoundException();
		Question question = questionService.findById(idQuestion).get();
		question.getQuiz().add(quiz);
		quiz.getQuestions().add(question);
		quizDAO.save(quiz);
	}
}
