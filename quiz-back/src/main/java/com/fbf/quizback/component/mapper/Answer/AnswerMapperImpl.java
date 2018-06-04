package com.fbf.quizback.component.mapper.Answer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fbf.quizback.component.mapper.AbstractMapper;
import com.fbf.quizback.dto.AnswerDTO;
import com.fbf.quizback.model.Answer;
import com.fbf.quizback.service.QuestionService;

@Component
public class AnswerMapperImpl extends AbstractMapper<Answer, AnswerDTO> implements AnswerMapper{

	@Autowired
	QuestionService questionService;
	
	@Override
	public Class<? extends AnswerDTO> dtoClazz() {
		// TODO Auto-generated method stub
		return AnswerDTO.class ;
	}

	@Override
	public Class<? extends Answer> modelClazz() {
		// TODO Auto-generated method stub
		return Answer.class;
	}
	
	@Override
	public Answer dtoToModel(AnswerDTO dto){
		Answer answer = dozer.map(dto, modelClazz());
		answer.setTextAnswer(dto.getAnswer());
		//Optional<Question> question = questionService.findById(dto.getIdAnswer());
		//if(question.isPresent())
		answer.setQuestion(questionService.findById(dto.getIdAnswer()).get());
		return answer;
	}
	
	@Override
	public AnswerDTO modelToDto(Answer answer) {
		AnswerDTO dto =  dozer.map(answer, dtoClazz());
		dto.setAnswer(answer.getTextAnswer());		
		return dto;
	}
	

}
