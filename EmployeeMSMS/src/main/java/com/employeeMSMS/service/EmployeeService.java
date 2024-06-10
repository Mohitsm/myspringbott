package com.employeeMSMS.service;

import java.util.List;

import com.employeeMSMS.paylode.EmployeeDto;

public interface EmployeeService {
	
	EmployeeDto createEmployee(EmployeeDto employeeDto);
	EmployeeDto updateEmployee(EmployeeDto employeeDto,Integer employeeId);
	void deleteEmployee(Integer employeeId);
	EmployeeDto getEmployeeId(Integer employeeId);
	List<EmployeeDto> getAllemployee();
	public Long count();
	public Double total();
	

}
