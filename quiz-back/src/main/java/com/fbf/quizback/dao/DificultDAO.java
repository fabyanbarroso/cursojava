package com.fbf.quizback.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.fbf.quizback.model.Dificult;

@Repository
public interface DificultDAO extends PagingAndSortingRepository<Dificult, Integer>{

}
