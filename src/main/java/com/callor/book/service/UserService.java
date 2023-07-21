package com.callor.book.service;

import java.util.List;

import com.callor.book.models.UserDto;

public interface UserService {

	public int join(UserDto userDto);
	
	public int count();

	public List<UserDto> selectAll();

	public UserDto findById(String id);

	public int update(UserDto userDto);

}
