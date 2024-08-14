package com.employee.dto;

import com.employee.entity.Employee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AttendanceDto {
	private long attendanceId;
	private String punchIn;
	private String punchout;
	private String status;
	

}
