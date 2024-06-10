package com.employee.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.dto.UserDto;
import com.employee.entity.User;
import com.employee.exception.ResourceNotFoundException;
import com.employee.repositiry.UserRepo;
import com.employee.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDto createUser(UserDto userDto) {
		// TODO Auto-generated method stub
		User user=this.modelMapper.map(userDto, User.class);
		User user2=this.userRepo.save(user);
		return this.modelMapper.map(user2, UserDto.class);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Long userId) {
		// TODO Auto-generated method stub
		User user=this.userRepo.findById(userId)
				.orElseThrow(()-> new ResourceNotFoundException("User","Id",userId));
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		
		User user2=this.userRepo.save(user);

		return this.modelMapper.map(user2, UserDto.class);
	}

	@Override
	public void deleteUser(Long userId) {
		// TODO Auto-generated method stub
		User user=this.userRepo.findById(userId)
				.orElseThrow(()-> new ResourceNotFoundException("User","Id",userId));

		this.userRepo.delete(user);
		
	}

	@Override
	public UserDto getUserById(Long userId) {
		// TODO Auto-generated method stub
		User user=this.userRepo.findById(userId)
				.orElseThrow(()-> new ResourceNotFoundException("User","Id",userId));

		return this.modelMapper.map(user, UserDto.class);
	}

	@Override
	public List<UserDto> getAllUser() {
		// TODO Auto-generated method stub
		List<User> users=this.userRepo.findAll();
		List<UserDto> userDtos=users.stream().map((u)->this.modelMapper.map(u, UserDto.class)).collect(Collectors.toList());
		return userDtos;
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return this.userRepo.count();
	}

}
