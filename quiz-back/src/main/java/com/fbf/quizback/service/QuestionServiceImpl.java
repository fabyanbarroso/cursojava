package com.fbf.quizback.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.fbf.quizback.dao.QuestionDAO;
import com.fbf.quizback.dto.QuestionDTO;
import com.fbf.quizback.exception.QuestionNotFoundException;
import com.fbf.quizback.exception.QuizNotFoundException;
import com.fbf.quizback.exception.TooManyAnswerException;
import com.fbf.quizback.model.Answer;
import com.fbf.quizback.model.Dificult;
import com.fbf.quizback.model.Question;
import com.fbf.quizback.model.Quiz;
import com.fbf.quizback.model.Tag;

@Service
public class QuestionServiceImpl implements QuestionService{

	@Autowired
	QuestionDAO questionDAO;
	
	@Autowired
	DificultService dificultService;
	
	@Autowired
	TagService tagService;
	
	@Autowired
	QuizService quizService;
	
	@Autowired
	AnswerService answerService;

	public Question create(Question t) {
		return questionDAO.save(t);
	}

	@Override
	public void update(Question t) {
		// TODO Auto-generated method stub
		questionDAO.save(t);
	}

	@Override
	public Optional<Question> findById(Integer id) {
		// TODO Auto-generated method stub
		return questionDAO.findById(id);
	}

	@Override
	public List<Question> findAll(Pageable p) {
		// TODO Auto-generated method stub
		int page = p.getPageNumber();
		int size = p.getPageSize();
		return questionDAO.findAll(PageRequest.of(page, size)).stream().collect(Collectors.toList());
	}

	@Override
	public void delete(Question t) {
		// TODO Auto-generated method stub
		questionDAO.delete(t);
	}

	@Override
	public Question create(Question question, int dificultLevel, int tagQuestion) {
		// TODO Auto-generated method stub
		if (dificultService.findById(dificultLevel).isPresent()) {
			question.setDificult(dificultService.findById(dificultLevel).get());
		}
		if (tagService.findById(tagQuestion).isPresent()) {
			question.setTag(tagService.findById(tagQuestion).get());
		}
		return questionDAO.save(question);
	}

	@Override
	public Answer createAnswer(int idQuestion, String textAnswer, boolean correctAnswer) throws QuestionNotFoundException, TooManyAnswerException {
		final Optional<Question> question = questionDAO.findById(idQuestion);
		if(answerService.findAllByQuestion(question.get()).size()>3)
			throw new TooManyAnswerException();
		
		if(!question.isPresent())
			throw new QuestionNotFoundException();
		final Answer answer = answerService.create(question.get(), textAnswer, correctAnswer);
		question.get().getAnswer().add(answer);
		update(question.get());
		return answer;
	}
	
	@Override
	public void deleteAnswerQuiz(Question question, int idAnswer) throws QuestionNotFoundException {

		Optional<Question> questionSearch = questionDAO.findById(question.getId_question());
		if(!questionSearch.isPresent())
			throw new QuestionNotFoundException();
	
		Question q = questionSearch.get();
		Optional<Answer> answer = answerService.findById(idAnswer);
		q.getAnswer().remove(answer.get());
		answerService.delete(answer.get());
		questionDAO.save(q);
	}
	
}