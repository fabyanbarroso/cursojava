package com.fbf.quizback.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.fbf.quizback.model.Answer;
import com.fbf.quizback.model.Question;

@Repository
public interface AnswerDAO extends PagingAndSortingRepository<Answer, Integer> {
	public Answer findByQuestion(Question question);
}
