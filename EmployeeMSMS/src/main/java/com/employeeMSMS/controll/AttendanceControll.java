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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employeeMSMS.paylode.ApiResponse;
import com.employeeMSMS.paylode.AttendanceDto;
import com.employeeMSMS.paylode.AttendanceResponse;
import com.employeeMSMS.service.AttendanceService;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceControll {
	
	@Autowired
	private AttendanceService attendanceService;
	
	//cretae
	@PostMapping("/")
	public ResponseEntity<AttendanceDto> createAttendance(@RequestBody AttendanceDto attendanceDto){
		
		AttendanceDto createAttendance=this.attendanceService.createAttendance(attendanceDto);
		
		return new ResponseEntity<AttendanceDto>(createAttendance,HttpStatus.CREATED);
	}

	//update
	@PutMapping("/{attendanceId}")
	public ResponseEntity<AttendanceDto> updateAttendance(@RequestBody AttendanceDto attendanceDto,@PathVariable Integer attendanceId){
		AttendanceDto updateAttendance=this.attendanceService.updateAttendance(attendanceDto, attendanceId);
		return ResponseEntity.ok(updateAttendance);
	}
	//delete
	@DeleteMapping("/{attendanceId}")
	public ResponseEntity<ApiResponse> deleteAttendance(@PathVariable Integer attendanceId){
		this.attendanceService.deleteAttendance(attendanceId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("category is deleted successfully !!", true),
				HttpStatus.OK); 
	}
	//getAttendanceById
	@GetMapping("/{attendanceId}")
	public ResponseEntity<AttendanceDto> getAttendanceById(@PathVariable Integer attendanceId){
		return ResponseEntity.ok(this.attendanceService.getAttendanceById(attendanceId));
	}
	//getAll
	@GetMapping("/")
	public ResponseEntity<AttendanceResponse> getAllAttendance(@RequestParam(value = "sortBy",defaultValue = "attendanceId",required = false)String sortBy){
		this.attendanceService.getAllAttendance(sortBy);
		return null;
//		

	}
}
