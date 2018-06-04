package com.fbf.quizback.controller;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.fbf.quizback.component.mapper.question.QuestionMapper;
import com.fbf.quizback.component.mapper.question.QuestionPostMapper;
import com.fbf.quizback.component.mapper.question.QuestionToShowMapper;
import com.fbf.quizback.dto.AnswerDTO;
import com.fbf.quizback.dto.QuestionDTO;
import com.fbf.quizback.dto.QuestionPostDTO;
import com.fbf.quizback.dto.QuestionToShowDTO;
import com.fbf.quizback.dto.QuizQuestionDTO;
import com.fbf.quizback.exception.QuestionNotFoundException;
import com.fbf.quizback.exception.QuizNotFoundException;
import com.fbf.quizback.exception.TooManyAnswerException;
import com.fbf.quizback.model.Question;
import com.fbf.quizback.service.QuestionService;
import com.fbf.quizback.service.QuizService;

@RestController
@RequestMapping(value = "/question")
public class QuestionController {

	@Autowired
	QuestionService questionService;
	
	@Autowired
	QuestionMapper questionMapper;
	
	@Autowired
	QuestionPostMapper questionPostMapper;
	
	@Autowired
	QuestionToShowMapper questionToShowMapper;
	
	/*
	@RequestMapping(method = RequestMethod.GET)
	public List<QuestionDTO> findAll(@RequestParam(defaultValue = "0", required = false) Integer page,
			@RequestParam(defaultValue = "10", required = false) Integer size) {
		final List<Question> questions = questionService.findAll(PageRequest.of(page, size));
		return questions.stream().map(question -> questionMapper.modelToDto(question)).collect(Collectors.toList());
		//return questionMapper.modelToDto(questions);
	}
	*/
	
	@RequestMapping(method = RequestMethod.GET)
	public List<QuestionToShowDTO> findAll(@RequestParam(defaultValue = "0", required = false) Integer page,
			@RequestParam(defaultValue = "10", required = false) Integer size) {
		final List<Question> questions = questionService.findAll(PageRequest.of(page, size));
		return questions.stream().map(question -> questionToShowMapper.modelToDto(question)).collect(Collectors.toList());
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public QuestionToShowDTO findById(@PathVariable("id") Integer id) throws QuestionNotFoundException {
		final Optional<Question> question = questionService.findById(id);
		if(!question.isPresent()) throw new QuestionNotFoundException();
		return questionToShowMapper.modelToDto(question.get());
	}

	@RequestMapping(method = RequestMethod.POST)
	public QuestionDTO create(@RequestBody QuestionPostDTO dto){
		final Question question = questionPostMapper.dtoToModel(dto);
		final Question createQuestion = questionService.create(question);
		return questionMapper.modelToDto(createQuestion);
	}
	
	//add answer for question by URL
	@RequestMapping(value = "/{id}/answer", method = RequestMethod.POST)
	public QuestionDTO createAnswer(@PathVariable("id") Integer idQuestion, @RequestBody AnswerDTO dto) throws QuestionNotFoundException, TooManyAnswerException{
		questionService.createAnswer(idQuestion, dto.getAnswer(), dto.getCorrect());
		Optional<Question> createAnswer = questionService.findById(idQuestion);
		if(!createAnswer.isPresent())
			throw new QuestionNotFoundException();
		return questionMapper.modelToDto(createAnswer.get());
	}
	
	//delete answer in quiz by URL
		@RequestMapping(value="/{id}/answer/{idAnswer}",method = RequestMethod.DELETE)
		public void deleteAnswerQuestion(@PathVariable("id") Integer idQuestion, 
				@PathVariable("idAnswer") Integer idAnswer) throws QuestionNotFoundException {
			if(!questionService.findById(idQuestion).isPresent())
				throw new QuestionNotFoundException();
			questionService.deleteAnswerQuiz(questionService.findById(idQuestion).get(), idAnswer);
		}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void update(@PathVariable("id") Integer id, @RequestBody QuestionPostDTO dto) throws QuestionNotFoundException{
		if(!questionService.findById(id).isPresent()) {
			throw new QuestionNotFoundException();
		}else {
			final Question question = questionService.findById(id).get();
			final Question questionEdit = questionPostMapper.dtoToModel(dto);
			question.setDificult(questionEdit.getDificult());
			question.setQuestion(questionEdit.getQuestion());
			question.setTag(questionEdit.getTag());
			questionService.update(question);
		}
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Integer id) {
		final Optional<Question> question = questionService.findById(id);
		questionService.delete(question.get());
	}
}
