package com.fbf.quizback.controller;

import java.util.Optional;
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
import com.fbf.quizback.component.mapper.question.QuestionToShowMapper;
import com.fbf.quizback.component.mapper.quiz.QuizMapper;
import com.fbf.quizback.component.mapper.quiz.QuizQuestionMapper;
import com.fbf.quizback.component.mapper.quiz.QuizToShowMapper;
import com.fbf.quizback.dto.QuestionDTO;
import com.fbf.quizback.dto.QuestionToShowDTO;
import com.fbf.quizback.dto.QuizDTO;
import com.fbf.quizback.dto.QuizQuestionDTO;
import com.fbf.quizback.dto.QuizToShowDTO;
import com.fbf.quizback.exception.QuestionNotFoundException;
import com.fbf.quizback.exception.QuizNotFoundException;
import com.fbf.quizback.exception.QuizUsedException;
import com.fbf.quizback.model.Question;
import com.fbf.quizback.model.Quiz;
import com.fbf.quizback.service.QuestionService;
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
	
	@Autowired
	QuizQuestionMapper quizQuestionMapper;
	
	@Autowired
	QuizToShowMapper quizToShowMapper;
	
	@Autowired
	QuestionToShowMapper questionToShowMapper;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<QuizToShowDTO> findAll(@RequestParam(defaultValue = "0", required = false) Integer page,
			@RequestParam(defaultValue = "10", required = false) Integer size) {
		final List<Quiz> quizs = quizService.findAll(PageRequest.of(page, size));
		return quizToShowMapper.modelToDto(quizs);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public QuizToShowDTO findById(@PathVariable("id") Integer id) throws QuizNotFoundException {
		final Optional<Quiz> quiz = quizService.findById(id);
		if(!quiz.isPresent())
			throw new QuizNotFoundException();
		return quizToShowMapper.modelToDto(quiz.get());
	}

	@RequestMapping(value = "/{id}/question", method = RequestMethod.GET)
	public List<QuestionToShowDTO> quizFindQuestion(@PathVariable("id") Integer id) throws QuestionNotFoundException, QuizNotFoundException {
		List<Question> questions = quizService.quizFindQuestion(id);
		return questionToShowMapper.modelToDto(questions);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public QuizDTO create(@RequestBody QuizDTO dto) {
		final Quiz quiz = quizMapper.dtoToModel(dto);
		final Quiz createQuiz = quizService.create(quiz);
		return quizMapper.modelToDto(createQuiz);
	}
	
	//add question to quiz by post and dto quiz-question
	@RequestMapping(value="/{id}/question",method = RequestMethod.POST)
	public QuizQuestionDTO addQuestion(@RequestBody QuizQuestionDTO dto ) throws QuizNotFoundException, QuestionNotFoundException {
		
		if(!quizService.findById(dto.getIdQuiz()).isPresent())
			throw new QuizNotFoundException();
		quizService.addQuestion(quizService.findById(dto.getIdQuiz()).get(), dto.getIdQuestion());
		
		return dto;
	}
	
	//add question to quiz by URL
	@RequestMapping(value="/{id}/question/{idquestion}",method = RequestMethod.PUT)
	public QuizToShowDTO addQuestionToQuiz(@PathVariable("id") Integer idQuiz,
			@PathVariable("idquestion") Integer idQuestion)
			throws QuizNotFoundException, QuestionNotFoundException {
		
		if(!quizService.findById(idQuiz).isPresent())
			throw new QuizNotFoundException();
		quizService.addQuestion(quizService.findById(idQuiz).get(), idQuestion);
		return quizToShowMapper.modelToDto(quizService.findById(idQuiz).get());
	}
	
	
	//delete question in quiz by URL
	@RequestMapping(value="/{id}/question/{idquestion}",method = RequestMethod.DELETE)
	public void deleteQuestionQuiz(@RequestBody QuizQuestionDTO dto ,
			@PathVariable("id") Integer idQuiz, @PathVariable("idquestion") Integer idQuestion)
			throws QuizNotFoundException, QuestionNotFoundException {
		if(!quizService.findById(idQuiz).isPresent())
			throw new QuizNotFoundException();
		quizService.deleteQuestionQuiz(quizService.findById(idQuiz).get(), idQuestion);
	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void update(@PathVariable("id") Integer id, @RequestBody QuizDTO dto) throws QuestionNotFoundException {
		if(!quizService.findById(id).isPresent())
			throw new QuestionNotFoundException();
		Quiz quiz = quizService.findById(id).get();
		quiz.setName(dto.getName());
		quizService.update(quiz);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Integer id) throws QuizNotFoundException, QuestionNotFoundException{
		if(!quizService.findById(id).isPresent())
			throw new QuizNotFoundException();
		final Quiz quiz = quizService.findById(id).get();
		quizService.delete(quiz);
	}
}