package com.employeeMSMS.paylode;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AttendanceResponse {

	private List<AttendanceDto> content;
	
}
