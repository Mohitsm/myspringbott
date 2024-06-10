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

import com.employeeMSMS.paylode.AdvanceDetailsDto;
import com.employeeMSMS.paylode.ApiResponse;
import com.employeeMSMS.paylode.BasicDetailsDto;
import com.employeeMSMS.service.AdvanceDetailsService;

@RestController
@RequestMapping("/api/advanceDetails")
public class AdvanceDetailsControll {
	
	@Autowired
	private AdvanceDetailsService advanceDetailsService;
	
	//create
			@PostMapping("/")
			public ResponseEntity<AdvanceDetailsDto> createAdvanceDetails(@RequestBody AdvanceDetailsDto advanceDetailsDto){
				AdvanceDetailsDto createAdvanceDetails=this.advanceDetailsService.createAdvanceDetails(advanceDetailsDto);
				return new ResponseEntity<AdvanceDetailsDto>(createAdvanceDetails,HttpStatus.CREATED);
			}
			
			//update
			@PutMapping("/{advanceDetailsId}")
			public ResponseEntity<AdvanceDetailsDto> updateAdvanceDetails(@RequestBody AdvanceDetailsDto advanceDetailsDto,@PathVariable Integer advanceDetailsId){
				AdvanceDetailsDto updateAdvanceDetails=this.advanceDetailsService.updateAdvanceDetails(advanceDetailsDto, advanceDetailsId);
				return ResponseEntity.ok(updateAdvanceDetails);
				
			}
			//delete
			@DeleteMapping("/{advanceDetailsId}")
			public ResponseEntity<ApiResponse> deleteAdvanceDetails(@PathVariable Integer advanceDetailsId){
				this.advanceDetailsService.deleteAdvanceDetails(advanceDetailsId);
				return new ResponseEntity<ApiResponse>(new ApiResponse("category is deleted successfully !!", true),
						HttpStatus.OK);
			}
			
			//getById
			@GetMapping("/{advanceDetailsId}")
			public ResponseEntity<AdvanceDetailsDto> getAdvanceDetailsById(@PathVariable Integer advanceDetailsId){
				return ResponseEntity.ok(this.advanceDetailsService.getAdvanceDetailsById(advanceDetailsId));
			}
			
			//getAllUser
			@GetMapping("/")
			public ResponseEntity<List<AdvanceDetailsDto>> getAllAdvanceDetails(){
				return ResponseEntity.ok(this.advanceDetailsService.getAllAdvanceDetails());
			}
		

}
