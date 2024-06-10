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
import com.employeeMSMS.paylode.FamilyDetailsDto;
import com.employeeMSMS.service.FamilyDetailsService;

@RestController
@RequestMapping("/api/familyDetails")
public class FamilyDetailsControll {
	
	@Autowired
	private FamilyDetailsService familyDetailsService;
	
	//create
	@PostMapping("/")
	public ResponseEntity<FamilyDetailsDto> createFamilyDetails(@RequestBody FamilyDetailsDto familyDetailsDto){
		FamilyDetailsDto createFamilyDetails=this.familyDetailsService.createFamilyDetails(familyDetailsDto);
		return new ResponseEntity<FamilyDetailsDto>(createFamilyDetails,HttpStatus.CREATED);
	}
	//update
	@PutMapping("/{familyDetailsId}")
	public ResponseEntity<FamilyDetailsDto> updateFamilyDetails(@RequestBody FamilyDetailsDto familyDetailsDto,@PathVariable Integer familyDetailsId){
		FamilyDetailsDto updateFamilyDetails=this.familyDetailsService.updateFamilyDetails(familyDetailsDto, familyDetailsId);
		return ResponseEntity.ok(updateFamilyDetails);
	}
	//delete
	@DeleteMapping("/{familyDetailsId}")
	public ResponseEntity<ApiResponse> deleteFAmilyDetails(@PathVariable Integer familyDetailsId ){
		this.familyDetailsService.deleteFamilyDetails(familyDetailsId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("category is deleted successfully !!", true),
				HttpStatus.OK);
	}
	//getById
	@GetMapping("/{familyDetailsId}")
	public ResponseEntity<FamilyDetailsDto> getFamilyDetailsById(@PathVariable Integer familyDetailsId){
		return ResponseEntity.ok(this.familyDetailsService.getFamilyDetailsById(familyDetailsId));
	}
	//getAll
	@GetMapping("/")
	public ResponseEntity<List<FamilyDetailsDto>> getAllFamilyDetails(){
		return ResponseEntity.ok(this.familyDetailsService.getAllFamilyDetails());
	}
	

}
