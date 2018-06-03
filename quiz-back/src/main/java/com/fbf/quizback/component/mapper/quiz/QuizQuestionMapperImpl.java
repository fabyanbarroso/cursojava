package com.fbf.quizback.component.mapper.quiz;

import org.springframework.stereotype.Component;

import com.fbf.quizback.component.mapper.AbstractMapper;
import com.fbf.quizback.dto.QuizQuestionDTO;
import com.fbf.quizback.model.Quiz;

@Component
public class QuizQuestionMapperImpl extends AbstractMapper<Quiz, QuizQuestionDTO> implements QuizQuestionMapper{

	@Override
	public Class<? extends QuizQuestionDTO> dtoClazz() {
		// TODO Auto-generated method stub
		return QuizQuestionDTO.class;
	}

	@Override
	public Class<? extends Quiz> modelClazz() {
		// TODO Auto-generated method stub
		return Quiz.class;
	}
	

}
