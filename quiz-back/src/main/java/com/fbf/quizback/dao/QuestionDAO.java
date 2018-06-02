package com.fbf.quizback.dao;


import java.util.Set;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.fbf.quizback.model.Question;
import com.fbf.quizback.model.Quiz;

@Repository
public interface QuestionDAO extends PagingAndSortingRepository<Question, Integer>{
}
