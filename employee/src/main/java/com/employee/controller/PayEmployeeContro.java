

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
import org.springframework.web.bind.annotation.RestController;

import com.employee.dto.ApiResponse;
import com.employee.dto.PayEmployeeDto;
import com.employee.service.PayEmployeeService;

//@CrossOrigin("*")
@RestController
@RequestMapping("/api/payEmployee")
public class PayEmployeeContro {
	
	@Autowired
	private PayEmployeeService payEmployeeService;
	
	//create
	@PostMapping("/")
	public ResponseEntity<PayEmployeeDto> createPayEmployee(@RequestBody PayEmployeeDto payEmployeeDto){
		PayEmployeeDto createPayEmployeeDto=this.payEmployeeService.createPayEmployee(payEmployeeDto);
		return new ResponseEntity<PayEmployeeDto>(createPayEmployeeDto,HttpStatus.CREATED);
	}

	//update
	@PutMapping("/{payEmployeeId}")
	public ResponseEntity<PayEmployeeDto> updatePayEmployee(@RequestBody PayEmployeeDto payEmployeeDto,@PathVariable Long payEmployeeId){
		PayEmployeeDto updatePayEmployeeDto=this.payEmployeeService.upadtePayEmployee(payEmployeeDto, payEmployeeId);
		return ResponseEntity.ok(updatePayEmployeeDto);
	}
	
	//delete
	@DeleteMapping("/{payEmployeeId}")
	public ResponseEntity<ApiResponse> deletePayResponseEntity(@PathVariable Long payEmployeeId){
		this.payEmployeeService.deletePayEmployee(payEmployeeId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User Dalete Successfully",true),HttpStatus.OK);

	}
	//getPayEmployeeId
	@GetMapping("/{payEmployeeId}")
	public ResponseEntity<PayEmployeeDto> getPayemployeeId(@PathVariable Long payEmployeeId){
		PayEmployeeDto getPayEmployeeDto=this.payEmployeeService.getPayEmployeeId(payEmployeeId);
		return ResponseEntity.ok(getPayEmployeeDto);
	}
	
	//getAllPAyEmployee
	@GetMapping("/")
	public ResponseEntity<List<PayEmployeeDto>> getAllPayEmployee(){
		return ResponseEntity.ok(this.payEmployeeService.getAllPayEmployee());
	}
}
