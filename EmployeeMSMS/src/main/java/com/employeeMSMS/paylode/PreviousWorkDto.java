package com.employeeMSMS.paylode;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PreviousWorkDto {
	private Integer previousWorkId;
	private String company;
	private String designationName;
	private String from;
	private String to;
	private String duration;

}
