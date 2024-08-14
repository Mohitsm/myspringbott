package com.employee.service;

import java.util.List;

import com.employee.dto.AttendanceDto;
import com.employee.dto.CalculateSalaryDto;
import com.employee.entity.Attendance;
import com.employee.entity.Employee;
import com.employee.repositiry.AttendanceRepo;

//public interface AttendanceService {
	
//	AttendanceDto createAttendance(AttendanceDto attendanceDto);
//	AttendanceDto updateAttendance(AttendanceDto attendanceDto,Long attendanceId);
//	void deleteAttendance(Long attendanceId);
//	AttendanceDto getAttendanceId(Long attendanceId);
//	List<AttendanceDto> getAllAttendance();
	

import java.time.LocalDateTime;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



public interface AttendanceService {
	AttendanceDto createAttendance(AttendanceDto attendanceDto);
	AttendanceDto updateAttendance(AttendanceDto attendanceDto,Long attendanceId);
	void deleteAttendance(Long attendanceId);
	AttendanceDto getAttendanceId(Long attendanceId);
	List<AttendanceDto> getAllAttendance();
}



