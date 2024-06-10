package com.employeeMSMS.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.employeeMSMS.entity.Attendance;
import com.employeeMSMS.exception.ResourceNotFoundException;
import com.employeeMSMS.paylode.AttendanceDto;
import com.employeeMSMS.paylode.AttendanceResponse;
import com.employeeMSMS.repositry.AttendanceRepo;
import com.employeeMSMS.service.AttendanceService;

@Service
public class AttendanceServiceImpl implements AttendanceService{
	
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
	public AttendanceDto updateAttendance(AttendanceDto attendanceDto, Integer attendanceId) {
		// TODO Auto-generated method stub
		Attendance attendance=this.attendanceRepo.findById(attendanceId).orElseThrow(()-> new ResourceNotFoundException("Attendance", "Id", attendanceId));
		
		attendance.setIntime(attendanceDto.getIntime());
		attendance.setOutTime(attendanceDto.getOutTime());
		Attendance updateAttendance=this.attendanceRepo.save(attendance);
		return this.modelMapper.map(updateAttendance, AttendanceDto.class);
	}

	@Override
	public void deleteAttendance(Integer attendanceId) {
		// TODO Auto-generated method stub
		Attendance attendance=this.attendanceRepo.findById(attendanceId).orElseThrow(()-> new ResourceNotFoundException("Attendance", "Id", attendanceId));

		this.attendanceRepo.delete(attendance);
		
		
	}

	@Override
	public AttendanceDto getAttendanceById(Integer attendanceId) {
		// TODO Auto-generated method stub
		Attendance attendance=this.attendanceRepo.findById(attendanceId).orElseThrow(()-> new ResourceNotFoundException("Attendance", "Id", attendanceId));

		
		return this.modelMapper.map(attendance,AttendanceDto.class);
	}

	@Override
	public AttendanceResponse getAllAttendance( String sortBy) {
		// TODO Auto-generated method stub
//		int pageSize=5;
//		int passNumber=1;
//		
//
//		
//		Pageable p=PageRequest.of(passNumber, pageSize);
//		Page<Attendance> pageAttendance=this.attendanceRepo.findAll(p);
		
		
		List<Attendance> attendances=this.attendanceRepo.findAll();
		List<AttendanceDto> getAllAttendance=attendances.stream().map((at)->this.modelMapper.map(at, AttendanceDto.class)).collect(Collectors.toList());
		AttendanceResponse attendanceResponse=new AttendanceResponse();
		attendanceResponse.setContent(getAllAttendance);
		
		return attendanceResponse;
	}

}
