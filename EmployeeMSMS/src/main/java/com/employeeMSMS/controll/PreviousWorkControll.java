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
import com.employeeMSMS.paylode.PreviousWorkDto;
import com.employeeMSMS.service.PreviousWorkService;

@RestController
@RequestMapping("/api/previousWork")
public class PreviousWorkControll {
	
	@Autowired
	private PreviousWorkService previousWorkService;
	
	//create
	@PostMapping("/")
	public ResponseEntity<PreviousWorkDto> createPreviousWork(@RequestBody PreviousWorkDto previousWorkDto){
		PreviousWorkDto createPreviousWork=this.previousWorkService.createPreviousWork(previousWorkDto);
		return new ResponseEntity<PreviousWorkDto>(createPreviousWork,HttpStatus.CREATED);
	}
	//update
	@PutMapping("/{previousWorkId}")
	public ResponseEntity<PreviousWorkDto> updatePreviousWork(@RequestBody PreviousWorkDto previousWorkDto,@PathVariable Integer previousWorkId){
	PreviousWorkDto updatePreviousWork=this.previousWorkService.updatePreviousWork(previousWorkDto, previousWorkId);
	return ResponseEntity.ok(updatePreviousWork);
	}
	
	//delete
	@DeleteMapping("/{previousWorkId}")
	public ResponseEntity<ApiResponse> deletePreviousWork(@PathVariable Integer previousWorkId){
		this.previousWorkService.deletePreviousWork(previousWorkId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("category is deleted successfully !!", true),
				HttpStatus.OK);
	}
	//getById
	@GetMapping("/{previousWorkId}")
	public ResponseEntity<PreviousWorkDto> getPreviousWorkById(@PathVariable Integer previousWorkId){
		return ResponseEntity.ok(this.previousWorkService.getPreviousWorkById(previousWorkId));
	}
	
	//getAkll
	@GetMapping("/")
	public ResponseEntity<List<PreviousWorkDto>> getAllPreviousWork(){
		return ResponseEntity.ok(this.previousWorkService.getAllPreviousWork());
	}

}
