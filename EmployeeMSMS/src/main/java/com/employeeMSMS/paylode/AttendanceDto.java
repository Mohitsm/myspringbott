package com.employeeMSMS.paylode;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AttendanceDto {
	private Integer attendanceId;
	private String intime;
	private String outTime;
	private String date;
	

}
