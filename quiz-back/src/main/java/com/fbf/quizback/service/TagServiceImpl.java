package com.fbf.quizback.service;

import java.util.Optional;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fbf.quizback.dao.TagDAO;
import com.fbf.quizback.model.Tag;

@Service
public class TagServiceImpl implements TagService{
	
	@Autowired
	TagDAO tagDAO;
	
	
	@Override
	public Tag create(Tag t) {
		// TODO Auto-generated method stub
		return tagDAO.save(t);
	}

	@Override
	public void update(Tag t) {
		// TODO Auto-generated method stub
		tagDAO.save(t);
	}

	@Override
	public Optional<Tag> findById(Integer id) {
		// TODO Auto-generated method stub
		return tagDAO.findById(id);
	}

	@Override
	public List<Tag> findAll(Pageable p) {
		// TODO Auto-generated method stub
		int page = p.getPageNumber();
		int size = p.getPageSize();
		return tagDAO.findAll(PageRequest.of(page, size)).stream().collect(Collectors.toList());
	}

	@Override
	public void delete(Tag t) {
		// TODO Auto-generated method stub
		tagDAO.delete(t);
	}



}
