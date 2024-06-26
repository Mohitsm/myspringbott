package com.employee.serviceImpl;

import java.util.List;

import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.entity.Employee;
import com.employee.exception.ResourceNotFoundException;
import com.employee.dto.EmployeeDto;
import com.employee.repositiry.EmployeeRepo;
import com.employee.service.EmployeeService;


@Service
public class EmployeeServiceImp implements EmployeeService {
	
	
	@Autowired
	private EmployeeRepo employeeRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		// TODO Auto-generated method stub
		Employee employee=this.modelMapper.map(employeeDto, Employee.class);
		Employee createEmployee=this.employeeRepo.save(employee);
		
		return this.modelMapper.map(createEmployee, EmployeeDto.class);
	}

	@Override
	public EmployeeDto updateEmployee(EmployeeDto employeeDto, Long employeeId) {
		// TODO Auto-generated method stub
		Employee employee=this.employeeRepo.findById(employeeId).orElseThrow(()-> new ResourceNotFoundException("Employee", "Id", employeeId));

		employee.setName(employeeDto.getName());
		employee.setEmail(employeeDto.getEmail());
		employee.setPassword(employeeDto.getPassword());
		employee.setSalary(employeeDto.getSalary());
		employee.setAddress(employeeDto.getAddress());
//		employee.setCategory(employeeDto.getCategory());
		
		Employee updateEmployee=this.employeeRepo.save(employee);
		return this.modelMapper.map(updateEmployee, EmployeeDto.class);
	}

	@Override
	public void deleteEmployee(Long employeeId) {
		// TODO Auto-generated method stub
		Employee employee=this.employeeRepo.findById(employeeId).orElseThrow(()-> new ResourceNotFoundException("Employee", "Id", employeeId));
		this.employeeRepo.delete(employee);
		
	}

	@Override
	public EmployeeDto getEmployeeId(Long employeeId) {
		// TODO Auto-generated method stub
		Employee employee=this.employeeRepo.findById(employeeId).orElseThrow(()-> new ResourceNotFoundException("Employee", "Id", employeeId));

		return this.modelMapper.map(employee, EmployeeDto.class);
	}

	@Override
	public List<EmployeeDto> getAllEmployee() {
		// TODO Auto-generated method stub
		List<Employee> employees=this.employeeRepo.findAll();
		List<EmployeeDto> employeeDtos=employees.stream().map((em)-> this.modelMapper.map(em, EmployeeDto.class)).collect(Collectors.toList());
		return employeeDtos;
	}

	@Override
	public Long countEmployee() {
		// TODO Auto-generated method stub
		return this.employeeRepo.count();
	}

}
