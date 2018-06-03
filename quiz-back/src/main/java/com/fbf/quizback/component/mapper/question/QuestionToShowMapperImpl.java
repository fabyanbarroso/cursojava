package com.fbf.quizback.component.mapper.question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.stream.Collectors;
import com.fbf.quizback.component.mapper.AbstractMapper;
import com.fbf.quizback.dto.QuestionToShowDTO;
import com.fbf.quizback.exception.DificultNotFoundException;
import com.fbf.quizback.model.Dificult;
import com.fbf.quizback.model.Question;
import com.fbf.quizback.model.Tag;
import com.fbf.quizback.service.DificultService;
import com.fbf.quizback.service.TagService;

@Component
public class QuestionToShowMapperImpl extends AbstractMapper<Question, QuestionToShowDTO> implements QuestionToShowMapper{
	@Autowired
	DificultService dificultService;
	
	@Autowired
	TagService tagService;
	
	@Override
	public Class<? extends QuestionToShowDTO> dtoClazz() {
		// TODO Auto-generated method stub
		return QuestionToShowDTO.class;
	}

	@Override
	public Class<? extends Question> modelClazz() {
		// TODO Auto-generated method stub
		return Question.class;
	}
	
	@Override
	public QuestionToShowDTO modelToDto(Question question) {
		QuestionToShowDTO dto = new QuestionToShowDTO();
		dto.setIdQuestion(question.getId_question());
		dto.setQuestion(question.getQuestion());
		/*
		Optional<Dificult> d = dificultService.findById(question.getDificult().getDificult());
		if(d.isPresent())
			dto.setDificult(dificultService.findById(question.getDificult().getIdDificult()).get().getDificult());
		Optional<Tag> tag = tagService.findById(question.getTag().getIdTag());
		if(tag.isPresent());
			dto.setTag(tagService.findById(question.getTag().getIdTag()).get().getName());
			*/
		return dto;
	}
}

