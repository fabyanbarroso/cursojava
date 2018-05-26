package com.fbf.quizback.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.fbf.quizback.model.Result;

@Repository
public interface ResultDAO extends PagingAndSortingRepository<Result, Integer>{

}
