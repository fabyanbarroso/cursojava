package com.fbf.quizback.controller;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fbf.quizback.component.mapper.question.QuestionMapper;
import com.fbf.quizback.component.mapper.quiz.QuizMapper;
import com.fbf.quizback.dto.QuestionDTO;
import com.fbf.quizback.dto.QuizDTO;
import com.fbf.quizback.dto.QuizQuestionDTO;
import com.fbf.quizback.exception.QuestionNotFoundException;
import com.fbf.quizback.exception.QuizNotFoundException;
import com.fbf.quizback.model.Question;
import com.fbf.quizback.model.Quiz;
import com.fbf.quizback.service.QuizService;

@RestController
@RequestMapping(value = "/quiz")
public class QuizController {

	@Autowired
	QuizService quizService;
	
	@Autowired
	QuizMapper quizMapper;
	
	@Autowired
	QuestionMapper questionMapper;
	
	@RequestMapping(method = RequestMethod.GET)
	public Set<QuizDTO> findAll(@RequestParam(defaultValue = "0", required = false) Integer page,
			@RequestParam(defaultValue = "10", required = false) Integer size) {
		final Set<Quiz> quizs = quizService.findAll(PageRequest.of(page, size));
		return quizMapper.modelToDto(quizs);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public QuizDTO findById(@PathVariable("id") Integer id) {
		final Optional<Quiz> quiz = quizService.findById(id);
		return quizMapper.modelToDto(quiz.get());
	}

	@RequestMapping(value = "/{id}/question", method = RequestMethod.GET)
	public Set<QuestionDTO> quizFindQuestion(@PathVariable("id") Integer id) throws QuestionNotFoundException, QuizNotFoundException {
	System.out.println("------------_"+id);
		Set<Question> questions = quizService.quizFindQuestion(id);
		return questionMapper.modelToDto(questions);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public QuizDTO create(@RequestBody QuizDTO dto) {
		final Quiz quiz = quizMapper.dtoToModel(dto);
		final Quiz createQuiz = quizService.create(quiz, dto.getId_course());
		return quizMapper.modelToDto(createQuiz);
	}
	

	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void update(@PathVariable("id") Integer id, @RequestBody QuizDTO dto) {
		final Optional<Quiz> quiz = quizService.findById(id);
		Quiz userEdit = quizMapper.dtoToModel(dto);
		quiz.get().setCourse(userEdit.getCourse());
		quizService.update(quiz.get());
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Integer id) {
		final Optional<Quiz> quiz = quizService.findById(id);
		quizService.delete(quiz.get());
	}
}