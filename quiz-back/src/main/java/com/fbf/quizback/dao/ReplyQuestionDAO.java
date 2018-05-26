package com.fbf.quizback.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.fbf.quizback.model.ReplyQuestion;

@Repository
public interface ReplyQuestionDAO extends PagingAndSortingRepository<ReplyQuestion, Integer> {

}
