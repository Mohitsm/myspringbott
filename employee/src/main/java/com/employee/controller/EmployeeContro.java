package com.employee.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.employee.dto.ApiResponse;
import com.employee.dto.EmployeeDto;
import com.employee.service.EmployeeService;



@RestController
@RequestMapping("/api/employee")

public class EmployeeContro {
	
	@Autowired
	private EmployeeService employeeService;
	
	//create
	
	@PostMapping("/")
	public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
		EmployeeDto createEmployeeDto=this.employeeService.createEmployee(employeeDto);
		return new ResponseEntity<EmployeeDto>(createEmployeeDto,HttpStatus.CREATED);
	}
	//update
		@PutMapping("{employeeId}")
		public ResponseEntity<EmployeeDto> updateEmployee(@RequestBody EmployeeDto employeeDto,@PathVariable Long employeeId){
			EmployeeDto updateUser=this.employeeService.updateEmployee(employeeDto, employeeId);
			
			return  ResponseEntity.ok(updateUser);
		}
		
		@DeleteMapping("{employeeId}")
		public ResponseEntity<ApiResponse> daleteEmployee(@PathVariable Long employeeId){
			this.employeeService.deleteEmployee(employeeId);
			
			return new ResponseEntity<ApiResponse>(new ApiResponse("User Dalete Successfully",true),HttpStatus.OK);
		}
		
		@GetMapping("{employeeId}")
		public ResponseEntity<EmployeeDto> getEmployeeId(@PathVariable Long employeeId){
			return ResponseEntity.ok(this.employeeService.getEmployeeId(employeeId));
		}
		
		@GetMapping("/")
		public ResponseEntity<List<EmployeeDto>> getAllUser(){
			return ResponseEntity.ok(this.employeeService.getAllEmployee());
		}
		@PostMapping("/api/employee/")
		public ResponseEntity<String> addEmployee(@RequestParam("file") MultipartFile file, @RequestParam("otherParam") String otherParam) {
		    // your controller logic
			return null;
		}
		@GetMapping("/count")
		public ResponseEntity<Long> countEmployee(){
			return ResponseEntity.ok(this.employeeService.countEmployee());
		}
		

}
