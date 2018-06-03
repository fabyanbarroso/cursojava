package com.fbf.quizback.controller;

import java.util.Optional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.fbf.quizback.component.mapper.user.UserMapper;
import com.fbf.quizback.component.mapper.user.UserPostMapper;
import com.fbf.quizback.dto.UserDTO;
import com.fbf.quizback.dto.UserPostDTO;
import com.fbf.quizback.exception.UserNotFoundException;
import com.fbf.quizback.model.User;
import com.fbf.quizback.service.UserService;

 @RestController
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	UserMapper userMapper;
	
	@Autowired
	UserPostMapper userPostMapper;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<UserDTO> findAll(@RequestParam(defaultValue = "0", required = false) Integer page,
			@RequestParam(defaultValue = "10", required = false) Integer size) {
		final List<User> users = userService.findAll(PageRequest.of(page, size));
		return userMapper.modelToDto(users);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public UserDTO findById(@PathVariable("id") Integer id) throws UserNotFoundException{
		final Optional<User> user = userService.findById(id);
			if(!user.isPresent())
				throw new UserNotFoundException();
		return userMapper.modelToDto(user.get());
	}

	@RequestMapping(method = RequestMethod.POST)
	public UserPostDTO create(@RequestBody UserPostDTO dto) {
		final User user = userPostMapper.dtoToModel(dto);
		final User createUser = userService.create(user);
		return userPostMapper.modelToDto(createUser);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void update(@PathVariable("id") Integer id, @RequestBody UserPostDTO dto) throws UserNotFoundException {
		final Optional<User> user = userService.findById(id);
		if (!user.isPresent())
			throw new UserNotFoundException();
			
		User userEdit = userPostMapper.dtoToModel(dto);
		user.get().setName(userEdit.getName());
		user.get().setEmail(userEdit.getEmail());
		user.get().setPassword(userEdit.getPassword());
		userService.update(user.get());
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Integer id) throws UserNotFoundException{
		final Optional<User> user = userService.findById(id);
		if(!user.isPresent())
			throw new UserNotFoundException();
		userService.delete(user.get());
	}
}
