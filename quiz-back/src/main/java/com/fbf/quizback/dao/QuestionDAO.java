package com.fbf.quizback.dao;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.fbf.quizback.model.Question;

@Repository
public interface QuestionDAO extends PagingAndSortingRepository<Question, Integer>{
	Optional<Set<Question>> findAllByquiz(int idQuiz);
}
