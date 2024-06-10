package com.employee.service;

import java.util.List;


import com.employee.dto.PayEmployeeDto;

public interface PayEmployeeService {
	
	PayEmployeeDto createPayEmployee(PayEmployeeDto payEmployeeDto);
	PayEmployeeDto upadtePayEmployee(PayEmployeeDto payEmployeeDto,Long payEmployeeId);
	void deletePayEmployee(Long payEmployeeId);
	PayEmployeeDto getPayEmployeeId(Long payEmployeeId);
	List<PayEmployeeDto> getAllPayEmployee();

}
