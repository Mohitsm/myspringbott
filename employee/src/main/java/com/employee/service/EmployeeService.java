package com.employee.service;

import java.util.List;


import com.employee.dto.EmployeeDto;

public interface EmployeeService {
	
	EmployeeDto createEmployee(EmployeeDto employeeDto);
	EmployeeDto updateEmployee(EmployeeDto employeeDto,Long employeeId);
	void deleteEmployee(Long employeeId);
	EmployeeDto getEmployeeId(Long employeeId);
	List<EmployeeDto> getAllEmployee();

}
