package com.employeeMSMS.paylode;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

	private Integer employeeId;
	private String name;
	private String email;
	private String password;
	private Double salary;
	private String address;
private String category;
	private String zmageName;
	public void setZmageName(byte[] bytes) {
		// TODO Auto-generated method stub
		
	}
	

}
