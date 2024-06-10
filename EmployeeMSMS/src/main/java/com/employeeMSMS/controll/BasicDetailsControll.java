package com.employeeMSMS.controll;

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

import com.employeeMSMS.paylode.ApiResponse;
import com.employeeMSMS.paylode.BasicDetailsDto;
import com.employeeMSMS.paylode.UserDto;
import com.employeeMSMS.service.BAsicDetailsService;

@RestController
@RequestMapping("/api/basicDetails")
public class BasicDetailsControll {
	
	@Autowired
	private BAsicDetailsService bAsicDetailsService;
	
	//create
		@PostMapping("/")
		public ResponseEntity<BasicDetailsDto> createBasicDetails(@RequestBody BasicDetailsDto basicDetailsDto){
			BasicDetailsDto createBasicDetails=this.bAsicDetailsService.createBasicDetails(basicDetailsDto);
			return new ResponseEntity<BasicDetailsDto>(createBasicDetails,HttpStatus.CREATED);
		}
		
		//update
		@PutMapping("/{basicDetailsId}")
		public ResponseEntity<BasicDetailsDto> updateBasicDetails(@RequestBody BasicDetailsDto basicDetailsDto,@PathVariable Integer basicDetailsId){
			BasicDetailsDto updateBasicDetails=this.bAsicDetailsService.updateBasicDetails(basicDetailsDto, basicDetailsId);
			return ResponseEntity.ok(updateBasicDetails);
			
		}
		//delete
		@DeleteMapping("/{basicDetailsId}")
		public ResponseEntity<ApiResponse> deleteBasicDetails(@PathVariable Integer basicDetailsId){
			this.bAsicDetailsService.deleteBasicDetails(basicDetailsId);
			return new ResponseEntity<ApiResponse>(new ApiResponse("category is deleted successfully !!", true),
					HttpStatus.OK);
		}
		
		//getById
		@GetMapping("/{basicDetailsId}")
		public ResponseEntity<BasicDetailsDto> getBasicDetailsById(@PathVariable Integer basicDetailsId){
			return ResponseEntity.ok(this.bAsicDetailsService.getBasicDetailsById(basicDetailsId));
		}
		
		//getAllUser
		@GetMapping("/")
		public ResponseEntity<List<BasicDetailsDto>> getAllUser(){
			return ResponseEntity.ok(this.bAsicDetailsService.getAllBasicDetails());
		}
	
	

}
