package com.fbf.quizback.component.mapper.question;

import org.springframework.stereotype.Component;
import com.fbf.quizback.component.mapper.AbstractMapper;
import com.fbf.quizback.dto.QuestionDTO;
import com.fbf.quizback.model.Question;

@Component
public class QuestionMapperImpl extends AbstractMapper<Question, QuestionDTO> implements QuestionMapper{

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
}
