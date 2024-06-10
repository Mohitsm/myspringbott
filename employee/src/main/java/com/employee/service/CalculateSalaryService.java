package com.employee.service;

import java.util.List;

import com.employee.dto.CalculateSalaryDto;




public interface CalculateSalaryService {
	
	CalculateSalaryDto createCalculateSalary(CalculateSalaryDto CalculateSalaryDto);
	CalculateSalaryDto updateCalculateSalary(CalculateSalaryDto calculateSalaryDto,Long CalculateSalaryId);
	void deleteCalculateSalary(Long CalculateSalaryId);
	CalculateSalaryDto getCalculateSalaryId(Long CalculateSalaryId);
	List<CalculateSalaryDto> getAllCalculateSalary();

}
