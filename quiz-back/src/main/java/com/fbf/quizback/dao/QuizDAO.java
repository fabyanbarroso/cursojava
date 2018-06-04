package com.fbf.quizback.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.fbf.quizback.model.Quiz;

@Repository
public interface QuizDAO extends PagingAndSortingRepository<Quiz, Integer>{


}
