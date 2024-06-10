package com.employee.service;

import java.util.List;

import com.employee.dto.UserDto;

public interface UserService {
	
	UserDto createUser(UserDto userDto);
	UserDto updateUser(UserDto userDto,Long userId);
	void deleteUser(Long userId);
	UserDto getUserById(Long userId);
	List<UserDto> getAllUser();
	public Long count();

}
