package com.employeeMSMS.controll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employeeMSMS.entity.Mohit1;
import com.employeeMSMS.paylode.MohitDto;
import com.employeeMSMS.service.Mohit1Service;
import com.employeeMSMS.service.Mohit2Service;
import com.employeeMSMS.service.Mohit3Service;

@RequestMapping("api/mohit")
@RestController
public class MohitControll {
	
	@Autowired
	private Mohit1Service mohit1Service;
	@Autowired
	private Mohit2Service mohit2Service;
	@Autowired
	private Mohit3Service mohit3Service;
	
	//create
	@PostMapping("/")
	public ResponseEntity<MohitDto> createMohit(@RequestBody MohitDto mohitDto){
		MohitDto createMohit1=this.mohit1Service.createMohit(mohitDto);
		MohitDto createMohit2=this.mohit2Service.createMohit(mohitDto);
		MohitDto createMohit3=this.mohit3Service.createMohit(mohitDto);
		return new ResponseEntity<MohitDto>((createMohit1),HttpStatus.CREATED);
	}
	
	//getAllmohit
//	


	

}
