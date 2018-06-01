package com.fbf.quizback.service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.fbf.quizback.dao.QuestionDAO;
import com.fbf.quizback.dto.QuestionDTO;
import com.fbf.quizback.model.Dificult;
import com.fbf.quizback.model.Question;
import com.fbf.quizback.model.Tag;

@Service
public class QuestionServiceImpl implements QuestionService{

	@Autowired
	QuestionDAO questionDAO;
	
	@Autowired
	DificultService dificultService;
	
	@Autowired
	TagService tagService;

	public Question create(Question t) {
		return questionDAO.save(t);
	}

	@Override
	public void update(Question t) {
		// TODO Auto-generated method stub
		questionDAO.save(t);
	}

	@Override
	public Optional<Question> findById(Integer id) {
		// TODO Auto-generated method stub
		return questionDAO.findById(id);
	}

	@Override
	public Set<Question> findAll(Pageable p) {
		// TODO Auto-generated method stub
		int page = p.getPageNumber();
		int size = p.getPageSize();
		return questionDAO.findAll(PageRequest.of(page, size)).stream().collect(Collectors.toSet());
	}

	@Override
	public void delete(Question t) {
		// TODO Auto-generated method stub
		questionDAO.delete(t);
	}

	@Override
	public Question create(Question question, int dificultLevel, int tagQuestion) {
		// TODO Auto-generated method stub
		if (dificultService.findById(dificultLevel).isPresent()) {
			question.setDificult(dificultService.findById(dificultLevel).get());
		}
		if (tagService.findById(tagQuestion).isPresent()) {
			question.setTag(tagService.findById(tagQuestion).get());
		}
		return questionDAO.save(question);
	}
}