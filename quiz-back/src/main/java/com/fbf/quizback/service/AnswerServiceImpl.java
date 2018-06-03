package com.fbf.quizback.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fbf.quizback.dao.AnswerDAO;
import com.fbf.quizback.model.Answer;

@Service
public class AnswerServiceImpl implements AnswerService{

	@Autowired
	AnswerDAO answerDAO;
	
	@Override
	public Answer create(Answer t) {
		// TODO Auto-generated method stub
		return answerDAO.save(t);
	}

	@Override
	public void update(Answer t) {
		// TODO Auto-generated method stub
		answerDAO.save(t);
	}

	@Override
	public Optional<Answer> findById(Integer id) {
		// TODO Auto-generated method stub
		return answerDAO.findById(id);
	}

	@Override
	public List<Answer> findAll(Pageable p) {
		// TODO Auto-generated method stub
		int page = p.getPageNumber();
		int size = p.getPageSize();
		return answerDAO.findAll(PageRequest.of(page, size)).stream().collect(Collectors.toList());
	}

	@Override
	public void delete(Answer t) {
		// TODO Auto-generated method stub
		answerDAO.delete(t);
	}

}
