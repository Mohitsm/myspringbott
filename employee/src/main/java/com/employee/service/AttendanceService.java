package com.employee.service;

import java.util.List;

import com.employee.dto.AttendanceDto;




public interface AttendanceService {
	
	AttendanceDto createAttendance(AttendanceDto attendanceDto);
	AttendanceDto updateAttendance(AttendanceDto attendanceDto,Long attendanceId);
	void deleteAttendance(Long attendanceId);
	AttendanceDto getAttendanceId(Long attendanceId);
	List<AttendanceDto> getAllAttendance();

}
