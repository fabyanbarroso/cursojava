package com.fbf.quizback.component.mapper.question;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fbf.quizback.component.mapper.AbstractMapper;
import com.fbf.quizback.dao.QuestionDAO;
import com.fbf.quizback.dto.QuestionPostDTO;
import com.fbf.quizback.model.Question;
import com.fbf.quizback.model.Quiz;
import com.fbf.quizback.service.DificultService;
import com.fbf.quizback.service.QuestionService;
import com.fbf.quizback.service.QuizService;
import com.fbf.quizback.service.TagService;

@Component
public class QuestionPostMapperImpl extends AbstractMapper<Question, QuestionPostDTO> implements QuestionPostMapper{
	@Autowired
	DificultService dificultService;
	
	@Autowired
	QuizService quizService;
	
	@Autowired
	QuestionService questionService;
	
	@Autowired
	TagService tagService;
	
	@Autowired
	QuestionDAO questionDAO;
	
	@Override
	public Class<? extends QuestionPostDTO> dtoClazz() {
		// TODO Auto-generated method stub
		return QuestionPostDTO.class;
	}

	@Override
	public Class<? extends Question> modelClazz() {
		// TODO Auto-generated method stub
		return Question.class;
	}
	
	/*
	@Override
	public QuestionPostDTO modelToDto(Question question) {
		QuestionPostDTO dto = dozer.map(question, dtoClazz());
		dto.setDificultLevel(question.getDificult().getIdDificult());
		dto.setTagQuestion(question.getTag().getIdTag());
		return dto;
	}
	*/
	
	@Override
	public Question dtoToModel(QuestionPostDTO dto) {
		Question question = dozer.map(dto, modelClazz());
		question.setQuestion(dto.getQuestion());
		question.setDificult(dificultService.findById(dto.getDificultLevel()).get());
		System.out.println("tag"+tagService.findById(dto.getTagQuestion()).get().getIdTag());
		question.setTag(tagService.findById(dto.getTagQuestion()).get());
		
		/*
		
		Quiz quiz = quizService.findById(dto.getIdQuiz()).get();
		System.out.println("questionary"+quiz.getId_quiz());
		System.out.println("Lista"+ questionService.findById(question.getId_question()).isPresent());
		if(!questionService.findById(question.getId_question()).isPresent()) {
			List<Quiz> quizs = new ArrayList<Quiz>();
			quizs.add(quiz);

			
		}else {
			List<Quiz> quizs = questionService.findById(question.getId_question()).get().getQuiz();
			quizs.add(quiz);
			question.setQuiz(quizs);
		}
		//question.setAnswer(dto.getAnswer());
		 * 
		 */
		return question;
	}
}