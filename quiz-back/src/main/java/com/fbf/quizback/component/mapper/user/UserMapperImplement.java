package com.fbf.quizback.component.mapper.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.fbf.quizback.component.mapper.AbstractMapper;
import com.fbf.quizback.dto.UserDTO;
import com.fbf.quizback.model.User;

@Component
public class UserMapperImplement extends AbstractMapper<User, UserDTO> implements UserMapper{

	@Override
	public Class<? extends UserDTO> dtoClazz() {
		// TODO Auto-generated method stub
		return UserDTO.class;
	}

	@Override
	public Class<? extends User> modelClazz() {
		// TODO Auto-generated method stub
		return User.class;
	}
}
