package com.fbf.quizback.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fbf.quizback.dao.DificultDAO;
import com.fbf.quizback.model.Dificult;

@Service
public class DificultServiceImpl implements DificultService{
	
	@Autowired
	DificultDAO dificultDAO;
	
	@Override
	public Dificult create(Dificult t) {
		// TODO Auto-generated method stub
		return dificultDAO.save(t);
	}

	@Override
	public void update(Dificult t) {
		// TODO Auto-generated method stub
		dificultDAO.save(t);
	}

	@Override
	public Optional<Dificult> findById(Integer id) {
		// TODO Auto-generated method stub
		return dificultDAO.findById(id);
	}

	@Override
	public List<Dificult> findAll(Pageable p) {
		// TODO Auto-generated method stub
		int page = p.getPageNumber();
		int size = p.getPageSize();
		return dificultDAO.findAll(PageRequest.of(page, size)).stream().collect(Collectors.toList());
	}

	@Override
	public void delete(Dificult t) {
		// TODO Auto-generated method stub
		dificultDAO.delete(t);
	}


}
