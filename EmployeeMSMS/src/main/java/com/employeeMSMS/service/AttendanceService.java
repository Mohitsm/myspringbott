package com.employeeMSMS.service;

import java.util.List;


import com.employeeMSMS.paylode.AttendanceDto;
import com.employeeMSMS.paylode.AttendanceResponse;


public interface AttendanceService {
	AttendanceDto createAttendance(AttendanceDto attendanceDto);
	AttendanceDto updateAttendance(AttendanceDto attendanceDto,Integer attendanceId);
	void deleteAttendance(Integer attendanceId);
	AttendanceDto getAttendanceById(Integer attendanceId);
	AttendanceResponse getAllAttendance(String sortBy);

}
