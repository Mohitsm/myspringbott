package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.dto.ApiResponse;
import com.employee.dto.UserDto;
import com.employee.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserCotroller {
	
	@Autowired
	private UserService userService;
	//get create user
		@PostMapping("/")
		public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto)
		{
			UserDto createUserDto =this.userService.createUser(userDto);
			return new ResponseEntity<>(createUserDto,HttpStatus.CREATED);
		}
		
		//put update user
		@PutMapping("/{userId}")
		public ResponseEntity<UserDto> updateUser( @RequestBody UserDto userDto,@PathVariable Long userId){
			UserDto updateUser=this.userService.updateUser(userDto, userId);
			return ResponseEntity.ok(updateUser);
			
		}
		
		//delete delete user
		@DeleteMapping("/{userId}")
		public ResponseEntity<ApiResponse> deleteUser(@PathVariable Long userId){
			this.userService.deleteUser(userId);
			return new ResponseEntity<ApiResponse>(new ApiResponse("user delete successfullly",true),HttpStatus.OK);
			
		}
		
		
		//get user get
		@GetMapping("/")
		public ResponseEntity<List<UserDto>> getAllUser(){
			return ResponseEntity.ok(this.userService.getAllUser());
		}
		
		//get user get
		@GetMapping("/{userId}")
		public ResponseEntity<UserDto> getSingleUser(@PathVariable Long userId){
			return ResponseEntity.ok(this.userService.getUserById(userId));
		}
		
		//count user
		@GetMapping("/count")
	    public ResponseEntity<Long> countUsers() {
	        long count = userService.count();
	        return ResponseEntity.ok(count);
	    }


}
