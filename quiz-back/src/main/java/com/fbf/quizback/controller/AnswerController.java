package com.fbf.quizback.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.fbf.quizback.component.mapper.Answer.AnswerMapper;
import com.fbf.quizback.dto.AnswerDTO;
import com.fbf.quizback.dto.QuestionToShowDTO;
import com.fbf.quizback.dto.QuizDTO;
import com.fbf.quizback.exception.QuestionNotFoundException;
import com.fbf.quizback.exception.QuizNotFoundException;
import com.fbf.quizback.model.Answer;
import com.fbf.quizback.model.Question;
import com.fbf.quizback.model.Quiz;
import com.fbf.quizback.service.AnswerService;

@RestController
@RequestMapping(value = "/answer")
public class AnswerController {

	@Autowired
	AnswerService answerService;
	
	@Autowired
	AnswerMapper answerMapper;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<AnswerDTO> findAll(@RequestParam(defaultValue = "0", required = false) Integer page,
			@RequestParam(defaultValue = "10", required = false) Integer size) {
		final List<Answer> answers = answerService.findAll(PageRequest.of(page, size));
		//return answerMapper.modelToDto(answers);
		return answers.stream().map(answer -> answerMapper.modelToDto(answer)).collect(Collectors.toList());
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public AnswerDTO create(@RequestBody AnswerDTO dto) {
		final Answer answer = answerMapper.dtoToModel(dto);
		final Answer createAnswer = answerService.create(answer);
		return answerMapper.modelToDto(createAnswer);
	}

	
}
