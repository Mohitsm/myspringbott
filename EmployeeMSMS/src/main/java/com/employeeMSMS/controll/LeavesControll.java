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
import com.employeeMSMS.paylode.LeavesDto;
import com.employeeMSMS.service.LeavesService;
@RestController
@RequestMapping("/api/leaves")
public class LeavesControll {
	
	@Autowired
	private LeavesService leavesService;
	
	@PostMapping("/")
	public ResponseEntity<LeavesDto> createAr(@RequestBody LeavesDto leavesDto){
		LeavesDto createAr=this.leavesService.createLeaves(leavesDto);
		return new ResponseEntity<LeavesDto>(createAr,HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<LeavesDto>> getAllAr(){
		return ResponseEntity.ok(this.leavesService.getAllLeaves());
	}
	
	@GetMapping("/counts")
	 public ResponseEntity<Long> count() {
      long count = leavesService.count();
      return ResponseEntity.ok(count);
  }
	 @GetMapping("/countm")
	 public ResponseEntity<Long> countApprovedEmployees() {
      long count = leavesService.countApprovedEmployees();
      return ResponseEntity.ok(count);
  }
	 @GetMapping("/countf")
	 public ResponseEntity<Long> countPendingEmployees() {
      long count = leavesService.countPendingEmployees();
      return ResponseEntity.ok(count);
  }
	 @GetMapping("/countt")
	 public ResponseEntity<Long> countRejectedEmployees() {
      long count = leavesService.countRejectedEmployees();
      return ResponseEntity.ok(count);
  }

}
