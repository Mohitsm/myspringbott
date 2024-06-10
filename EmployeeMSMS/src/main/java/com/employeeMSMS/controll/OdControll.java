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
import com.employeeMSMS.paylode.OdDto;
import com.employeeMSMS.service.OdService;
@RestController
@RequestMapping("/api/od")
public class OdControll {
	
	@Autowired
	private OdService odService;
	
	//create
	@PostMapping("/")
	public ResponseEntity<OdDto> createAr(@RequestBody OdDto odDto){
		OdDto createAr=this.odService.createOd(odDto);
		return new ResponseEntity<OdDto>(createAr,HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<OdDto>> getAllAr(){
		return ResponseEntity.ok(this.odService.getAllOd());
	}
	@GetMapping("/counts")
	 public ResponseEntity<Long> count() {
       long count = odService.count();
       return ResponseEntity.ok(count);
   }
	 @GetMapping("/countm")
	 public ResponseEntity<Long> countApprovedEmployees() {
       long count = odService.countApprovedEmployees();
       return ResponseEntity.ok(count);
   }
	 @GetMapping("/countf")
	 public ResponseEntity<Long> countPendingEmployees() {
       long count = odService.countPendingEmployees();
       return ResponseEntity.ok(count);
   }
	 @GetMapping("/countt")
	 public ResponseEntity<Long> countRejectedEmployees() {
       long count = odService.countRejectedEmployees();
       return ResponseEntity.ok(count);
   }
	

}
