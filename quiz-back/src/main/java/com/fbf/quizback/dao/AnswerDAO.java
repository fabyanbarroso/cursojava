package com.fbf.quizback.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.fbf.quizback.model.Answer;

@Repository
public interface AnswerDAO extends PagingAndSortingRepository<Answer, Integer> {

}
