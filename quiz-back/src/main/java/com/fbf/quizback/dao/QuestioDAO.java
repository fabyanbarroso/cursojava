package com.fbf.quizback.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.fbf.quizback.model.Question;

@Repository
public interface QuestioDAO extends PagingAndSortingRepository<Question, Integer>{

}
