package com.fbf.quizback.component.mapper.question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.fbf.quizback.component.mapper.AbstractMapper;
import com.fbf.quizback.dto.QuestionDTO;
import com.fbf.quizback.model.Question;
import com.fbf.quizback.service.DificultService;
import com.fbf.quizback.service.QuizService;

@Component
public class QuestionMapperImpl extends AbstractMapper<Question, QuestionDTO> implements QuestionMapper{
	@Autowired
	DificultService dificultService;
	
	@Autowired
	QuizService quizService;
	
	@Override
	public Class<? extends QuestionDTO> dtoClazz() {
		// TODO Auto-generated method stub
		return QuestionDTO.class;
	}

	@Override
	public Class<? extends Question> modelClazz() {
		// TODO Auto-generated method stub
		return Question.class;
	}
	
	@Override
	public QuestionDTO modelToDto(Question question) {
		QuestionDTO dto = dozer.map(question, dtoClazz());
		//dto.setDificultLevel(question.getDificult());
		//dto.setTagQuestion(question.getTag());
		return dto;
	}
}
