package com.fbf.quizback.service;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.domain.Pageable;

import com.fbf.quizback.model.Tag;

public interface TagService {
	Tag create(Tag t);
	
	void update(Tag t);
	
	Optional<Tag> findById(Integer id);
	
	Set<Tag> findAll(Pageable p);
	
	void delete(Tag t);
}
