package com.fbf.quizback.component.mapper.quiz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.fbf.quizback.component.mapper.AbstractMapper;
import com.fbf.quizback.dto.QuizDTO;
import com.fbf.quizback.model.Quiz;
import com.fbf.quizback.service.CourseService;



@Component
public class QuizMapperImpl extends AbstractMapper<Quiz, QuizDTO> implements QuizMapper{
	
	@Autowired
	CourseService courseService;
	
	@Override
	public Class<? extends QuizDTO> dtoClazz() {
		// TODO Auto-generated method stub
		return QuizDTO.class;
	}

	@Override
	public Class<? extends Quiz> modelClazz() {
		// TODO Auto-generated method stub
		return Quiz.class;
	}
}
