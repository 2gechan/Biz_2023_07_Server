package com.callor.book.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.callor.book.models.UserDto;
import com.callor.book.persistance.UserDao;
import com.callor.book.service.UserService;

@Service
public class UserServiceImplV1 implements UserService {



	protected final UserDao userDao;

	public UserServiceImplV1(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public int join(UserDto userDto) {
		return userDao.insert(userDto);

	}

	@Override
	public int count() {
		
		return userDao.userCount();
	}

	@Override
	public List<UserDto> selectAll() {
		List<UserDto> userList = userDao.selectAll();
		return userList;
	}
	
	@Override
	public UserDto findById(String id) {
		
		return userDao.findById(id);
	}

	@Override
	public int update(UserDto userDto) {
		
		return userDao.update(userDto);
	}
	
}
