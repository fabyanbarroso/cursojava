package com.fbf.quizback.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.fbf.quizback.model.User;

@Repository
public interface UserDAO extends PagingAndSortingRepository<User, Integer> {

}
