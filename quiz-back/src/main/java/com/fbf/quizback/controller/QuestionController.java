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
import com.fbf.quizback.dto.QuestionDTO;
import com.fbf.quizback.model.Question;
import com.fbf.quizback.service.QuestionService;
import com.fbf.quizback.service.QuestionServiceImpl;

@RestController
@RequestMapping(value = "/question")
public class QuestionController {

	@Autowired
	QuestionService questionService;
	
	@Autowired
	QuestionMapper questionMapper;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public Set<QuestionDTO> findAll(@RequestParam(defaultValue = "0", required = false) Integer page,
			@RequestParam(defaultValue = "10", required = false) Integer size) {
		final Set<Question> questions = questionService.findAll(PageRequest.of(page, size));
		return questionMapper.modelToDto(questions);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public QuestionDTO findById(@PathVariable("id") Integer id) {
		final Optional<Question> question = questionService.findById(id);
		return questionMapper.modelToDto(question.get());
	}

	@RequestMapping(method = RequestMethod.POST)
	public QuestionDTO create(@RequestBody QuestionDTO dto) {
		final Question question = questionMapper.dtoToModel(dto);
		final Question createQuestion = questionService.create(question, dto.getDificultLevel(), dto.getTagQuestion());
		return questionMapper.modelToDto(createQuestion);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void update(@PathVariable("id") Integer id, @RequestBody QuestionDTO dto) {
		final Optional<Question> question = questionService.findById(id);
		Question questionEdit = questionMapper.dtoToModel(dto);
		question.get().setQuestion(questionEdit.getQuestion());
		question.get().setDificult(questionEdit.getDificult());
		question.get().setAnswer(questionEdit.getAnswer());
		question.get().setQuiz(questionEdit.getQuiz());
		questionService.update(question.get());
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Integer id) {
		final Optional<Question> question = questionService.findById(id);
		questionService.delete(question.get());
	}
}
