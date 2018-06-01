package com.fbf.quizback.component.mapper.user;

import org.springframework.stereotype.Component;

import com.fbf.quizback.component.mapper.AbstractMapper;
import com.fbf.quizback.dto.UserPostDTO;
import com.fbf.quizback.model.User;

@Component
public class UserPostMapperImplement extends AbstractMapper<User, UserPostDTO> implements UserPostMapper{

	@Override
	public Class<? extends UserPostDTO> dtoClazz() {
		// TODO Auto-generated method stub
		return UserPostDTO.class;
	}

	@Override
	public Class<? extends User> modelClazz() {
		// TODO Auto-generated method stub
		return User.class;
	}
}
