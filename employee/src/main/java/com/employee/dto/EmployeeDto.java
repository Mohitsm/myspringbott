package com.employee.dto;

import java.util.List;

import com.employee.entity.CalculateSalary;

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
	private String mobile;
	private String dob;
	private String password;
	private String fname;
	private Double salary;
	private String address;
	private String jod;
	private String gender;
	private String category;
	private String marritalStatus;
	private String status;
	private String site;
	private String work;
	
}
