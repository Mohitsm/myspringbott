package com.employee.service;

import java.util.List;


import com.employee.dto.EmployeeDto;

public interface EmployeeService {
	
	EmployeeDto createEmployee(EmployeeDto employeeDto);
	EmployeeDto updateEmployee(EmployeeDto employeeDto,Long employeeId);
	void deleteEmployee(Long employeeId);
	EmployeeDto getEmployeeId(Long employeeId);
	List<EmployeeDto> getAllemployee();
	public Long count();
	public Double total();
	public long getMaleEmployeeCount();
	public long geFetmaleEmployeeCount();
	public long getTransEmployeeCount();
	public long getCurrentEmployees();
	public long getExEmployeeEmployees();
	public long getNewjoiningEmployees();
	public long getTransferredInEmployees();
	public long getTransferredOutEmployees();
	public long getExitedEmployeeEmployees();

}
