package com.employee.serviceImpl;

import java.util.List;

import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.entity.Attendance;
import com.employee.exception.ResourceNotFoundException;
import com.employee.dto.AttendanceDto;
import com.employee.repositiry.AttendanceRepo;
import com.employee.service.AttendanceService;
@Service
public class AttendanceServiceImp implements AttendanceService {
	
	@Autowired
	private AttendanceRepo attendanceRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public AttendanceDto createAttendance(AttendanceDto attendanceDto) {
		// TODO Auto-generated method stub
		Attendance attendance=this.modelMapper.map(attendanceDto, Attendance.class);
		Attendance createAttendance=this.attendanceRepo.save(attendance);
		return this.modelMapper.map(createAttendance, AttendanceDto.class);
	}

	@Override
	public AttendanceDto updateAttendance(AttendanceDto attendanceDto, Long attendanceId) {
		// TODO Auto-generated method stub
		Attendance attendance=this.attendanceRepo.findById(attendanceId).orElseThrow(()-> new ResourceNotFoundException("Attendance", "Id", attendanceId));
		
//		attendance.setPunchIn(attendanceDto.getPunchIn());
//		attendance.setPunchout(attendanceDto.getPunchout());
		Attendance updateAttendance=this.attendanceRepo.save(attendance);
		return this.modelMapper.map(updateAttendance, AttendanceDto.class);
	}

	@Override
	public void deleteAttendance(Long attendanceId) {
		// TODO Auto-generated method stub
		Attendance attendance=this.attendanceRepo.findById(attendanceId).orElseThrow(()-> new ResourceNotFoundException("Attendance", "Id", attendanceId));
		
		this.attendanceRepo.delete(attendance);

		
	}

	@Override
	public AttendanceDto getAttendanceId(Long attendanceId) {
		// TODO Auto-generated method stub
		Attendance attendance=this.attendanceRepo.findById(attendanceId).orElseThrow(()-> new ResourceNotFoundException("Attendance", "Id", attendanceId));

		
		return this.modelMapper.map(attendance, AttendanceDto.class);
	}

	@Override
	public List<AttendanceDto> getAllAttendance() {
		// TODO Auto-generated method stub
		List<Attendance> attendances=this.attendanceRepo.findAll();
		List<AttendanceDto> attendanceDtos=attendances.stream().map((at)->this.modelMapper.map(at, AttendanceDto.class)).collect(Collectors.toList());
		return attendanceDtos;
	}

}
