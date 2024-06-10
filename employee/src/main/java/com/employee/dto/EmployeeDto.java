package com.employee.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

	private long employeeId;
	private String name;
	private String email;
	private String password;
	private Double salary;
	private String address;
private String category;
	
}
