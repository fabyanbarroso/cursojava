package com.fbf.quizback.service;

import java.util.Optional;

import com.fbf.quizback.model.User;

public interface UserService extends AbstractCRUDService<User, Integer> {

	Optional<User> findByEmail(String email);

}
