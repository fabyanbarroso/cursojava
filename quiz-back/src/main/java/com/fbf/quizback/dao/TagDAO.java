package com.fbf.quizback.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.fbf.quizback.model.Tag;

@Repository
public interface TagDAO extends PagingAndSortingRepository<Tag, Integer>{

}
