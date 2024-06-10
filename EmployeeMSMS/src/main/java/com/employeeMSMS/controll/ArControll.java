package com.employeeMSMS.controll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employeeMSMS.paylode.ArDto;
import com.employeeMSMS.service.ArService;

@RestController
@RequestMapping("/api/ar")
public class ArControll {
	
	@Autowired
	private ArService arService;
	
	//create
	@PostMapping("/")
	public ResponseEntity<ArDto> createAr(@RequestBody ArDto arDto){
		ArDto createAr=this.arService.createAr(arDto);
		return new ResponseEntity<ArDto>(createAr,HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<ArDto>> getAllAr(){
		return ResponseEntity.ok(this.arService.getAllAr());
	}
	
	 @GetMapping("/counts")
	 public ResponseEntity<Long> count() {
        long count = arService.count();
        return ResponseEntity.ok(count);
    }
	 @GetMapping("/countm")
	 public ResponseEntity<Long> countApprovedEmployees() {
        long count = arService.countApprovedEmployees();
        return ResponseEntity.ok(count);
    }
	 @GetMapping("/countf")
	 public ResponseEntity<Long> countPendingEmployees() {
        long count = arService.countPendingEmployees();
        return ResponseEntity.ok(count);
    }
	 @GetMapping("/countt")
	 public ResponseEntity<Long> countRejectedEmployees() {
        long count = arService.countRejectedEmployees();
        return ResponseEntity.ok(count);
    }
	 
	

}
