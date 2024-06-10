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
import com.employeeMSMS.paylode.QualificationDto;
import com.employeeMSMS.service.QualificationService;

@RestController
@RequestMapping("/api/qualification")
public class QualificationControll {
	
	@Autowired
	private QualificationService qualificationService;
	
	//create
	@PostMapping("/")
	public ResponseEntity<QualificationDto> createQualification(@RequestBody QualificationDto qualificationDto){
		QualificationDto createQualification=this.qualificationService.createQualification(qualificationDto);
		return new ResponseEntity<QualificationDto>(createQualification,HttpStatus.CREATED);
		
	}
	
	//update
	@PutMapping("/{qualificationId}")
	public ResponseEntity<QualificationDto> updateQualification(@RequestBody QualificationDto qualificationDto,@PathVariable Integer qualificationId){
		QualificationDto updateQualification=this.qualificationService.updateQualification(qualificationDto, qualificationId);
		
		return ResponseEntity.ok(updateQualification);
		
	}
	//delete
	@DeleteMapping("/{qualificationId}")
	public ResponseEntity<ApiResponse> deleteQualification(@PathVariable Integer qualificationId){
		this.qualificationService.deleteQualification(qualificationId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("category is deleted successfully !!", true),
				HttpStatus.OK);
	}
	
	//getbyid
	@GetMapping("/{qualificationId}")
	public ResponseEntity<QualificationDto> getQualificationById(@PathVariable Integer qualificationId){
		return ResponseEntity.ok(this.qualificationService.getQualificationById(qualificationId));
	}
	//getAllQualification
	@GetMapping("/")
	public ResponseEntity<List<QualificationDto>> getAllQualification(){
		return ResponseEntity.ok(this.qualificationService.getaAllQualification());
	}

}
