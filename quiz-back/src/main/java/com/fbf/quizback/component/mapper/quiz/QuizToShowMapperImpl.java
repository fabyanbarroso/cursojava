package com.fbf.quizback.component.mapper.quiz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fbf.quizback.component.mapper.AbstractMapper;
import com.fbf.quizback.component.mapper.course.CourseMapper;
import com.fbf.quizback.component.mapper.question.QuestionToShowMapper;
import com.fbf.quizback.dto.QuestionToShowDTO;
import com.fbf.quizback.dto.QuizToShowDTO;
import com.fbf.quizback.model.Question;
import com.fbf.quizback.model.Quiz;
import com.fbf.quizback.service.CourseService;

@Component
public class QuizToShowMapperImpl extends AbstractMapper<Quiz, QuizToShowDTO> implements QuizToShowMapper {
	@Autowired
	QuestionToShowMapper questionToShowMapper;
	
	@Autowired
	QuestionToShowMapper questiontoShowMapper;
	
	@Autowired
	CourseMapper courseMapper;
	
	@Autowired 
	CourseService courseService;
	
	
	public QuizToShowDTO modelToDto(Quiz quiz) {
		QuizToShowDTO dto = dozer.map(quiz, dtoClazz());
		dto.setNameQuiz(quiz.getName());
		dto.setIdQuiz(quiz.getId_quiz());
		final Iterable<Question> questions = quiz.getQuestions();
		final List<QuestionToShowDTO> res = new ArrayList<>();
		questions.forEach(b -> {
			res.add(questiontoShowMapper.modelToDto(b));
		});
		Collections.shuffle(res);
		dto.setQuestion(res);
		return dto;
	}


	@Override
	public Class<? extends QuizToShowDTO> dtoClazz() {
		// TODO Auto-generated method stub
		return QuizToShowDTO.class;
	}


	@Override
	public Class<? extends Quiz> modelClazz() {
		// TODO Auto-generated method stub
		return Quiz.class;
	}
	
}
