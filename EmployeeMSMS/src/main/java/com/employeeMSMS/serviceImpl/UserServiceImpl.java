package com.employeeMSMS.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeeMSMS.entity.User;
import com.employeeMSMS.exception.ResourceNotFoundException;
import com.employeeMSMS.paylode.UserDto;
import com.employeeMSMS.repositry.UserRepo;
import com.employeeMSMS.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDto creatUser(UserDto userDto) {
		// TODO Auto-generated method stub
		User user=this.modelMapper.map(userDto, User.class);
		
		User createUser=this.userRepo.save(user);
		return this.modelMapper.map(createUser, UserDto.class);
	}

	@Override
	public UserDto updatUser(UserDto userDto, Integer userId) {
		// TODO Auto-generated method stub
		User user=this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "ID", userId));
		
		user.setName(userDto.getName());
		user.setMobile(userDto.getMobile());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		User updateUser=this.userRepo.save(user);
		return this.modelMapper.map(updateUser, UserDto.class);
	}

	@Override
	public void deleteUser(Integer userId) {
		// TODO Auto-generated method stub
		User user=this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "ID", userId));
		this.userRepo.delete(user);
		
	}

	@Override
	public UserDto getUserById(Integer userId) {
		// TODO Auto-generated method stub
		User user=this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "ID", userId));
		
		return this.modelMapper.map(user, UserDto.class);
	}

	@Override
	public List<UserDto> getAllUser() {
		// TODO Auto-generated method stub
		List<User> users=this.userRepo.findAll();
		List<UserDto> getAllUser=users.stream().map((ui)->this.modelMapper.map(ui, UserDto.class)).collect(Collectors.toList());
		return getAllUser;
	}

	@Override
	public Long countUsers() {
		// TODO Auto-generated method stub
		
		return userRepo.count();
	}

}
