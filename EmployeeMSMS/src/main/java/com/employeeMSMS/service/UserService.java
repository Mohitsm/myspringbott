package com.employeeMSMS.service;

import java.util.List;

import com.employeeMSMS.paylode.UserDto;

public interface UserService {
	
	UserDto creatUser(UserDto userDto);
	UserDto updatUser(UserDto userDto,Integer userId);
	void deleteUser(Integer userId);
	UserDto getUserById(Integer userId);
	List<UserDto> getAllUser();
	public Long countUsers();

}
