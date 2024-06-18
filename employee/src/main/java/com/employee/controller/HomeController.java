//package com.employee.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.employee.entity.Users;
//import com.employee.service.UsersService;
//
//@RestController
//@RequestMapping
//public class HomeController {
//	
//	@Autowired
//	private UsersService usersService;
//	
//	
//	
//	
//	
//	@PostMapping("/register")
//	public ResponseEntity<Users> saveUser(@RequestBody Users users,Model model){
//		Users users2=this.usersService.saveUsers(users);
//		model.addAttribute("massage","Resitered succuse ful");
//		return new ResponseEntity<Users>(users2,HttpStatus.CREATED);
//	}
//	
//	@GetMapping("/h")
//	public String ho() {
//		return "rstbgsdjs";
//	}
//	
//
//}
