package com.fbf.quizback.component.mapper.Answer;

import com.fbf.quizback.component.mapper.AbstractMapper;
import com.fbf.quizback.dto.AnswerDTO;
import com.fbf.quizback.model.Answer;

public class AnswerMapperImpl extends AbstractMapper<Answer, AnswerDTO>{

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

}
