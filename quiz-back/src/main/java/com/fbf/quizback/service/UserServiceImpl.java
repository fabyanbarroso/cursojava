package com.fbf.quizback.service;

import java.util.Optional;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.fbf.quizback.dao.UserDAO;
import com.fbf.quizback.model.User;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserDAO userDao;
	
	@Override
	public User create(User t) {
		// TODO Auto-generated method stub
		return userDao.save(t);
	}

	@Override
	public void update(User t) {
		// TODO Auto-generated method stub
		userDao.save(t);
	}

	@Override
	public Optional<User> findById(Integer id) {
		// TODO Auto-generated method stub
		return userDao.findById(id);
	}

	@Override
	public List<User> findAll(Pageable p) {
		// TODO Auto-generated method stub
		int page = p.getPageNumber();
		int size = p.getPageSize();
		return userDao.findAll(PageRequest.of(page, size)).stream().collect(Collectors.toList());
	}

	@Override
	public void delete(User t) {
		// TODO Auto-generated method stub
		userDao.delete(t);	
	}
	
	@Override
	public Optional<User> findByEmail(String email){
		return userDao.findUserByemail(email);
	}
}
