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
import com.employee.dto.AttendanceDto;
import com.employee.service.AttendanceService;

//@CrossOrigin(origins = "http://localhost:5173", maxAge = 3600)
@RestController
@RequestMapping("/api/attendance")
public class AttendaneContro {
	
	@Autowired
	private AttendanceService attendanceService;
	
	//create
	@PostMapping("/")
	public ResponseEntity<AttendanceDto> createAttendance(@RequestBody AttendanceDto attendanceDto){
		AttendanceDto createAttendance=this.attendanceService.createAttendance(attendanceDto);
		return new ResponseEntity<AttendanceDto>(createAttendance,HttpStatus.CREATED);
	}
	
	//update 
	@PutMapping("/{attendanceId}")
	public ResponseEntity<AttendanceDto> updateAttendance(@RequestBody AttendanceDto attendanceDto,@PathVariable Long attendanceId){
		AttendanceDto updateAttendance=this.attendanceService.updateAttendance(attendanceDto, attendanceId);
		return ResponseEntity.ok(updateAttendance);
	}
	 //delete
	
    @DeleteMapping("/{attendanceId}")
	public ResponseEntity<ApiResponse> deleteAttendance(@PathVariable Long attendanceId){
		this.attendanceService.deleteAttendance(attendanceId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User Dalete Successfully",true),HttpStatus.OK);

		
	}
	
	//getAttendanceId
    @GetMapping("/{attendanceId}")
	public ResponseEntity<AttendanceDto> getAttendanceId(@PathVariable Long attendanceId){
		return ResponseEntity.ok(this.attendanceService.getAttendanceId(attendanceId));
	}
	
	//getAttendanceAll
	@GetMapping("/")
	public ResponseEntity<List<AttendanceDto>> getAllAttendance(){
		return ResponseEntity.ok(this.attendanceService.getAllAttendance());
	}

}
