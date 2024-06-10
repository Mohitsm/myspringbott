package com.employeeMSMS.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeeMSMS.entity.Employee;
import com.employeeMSMS.exception.ResourceNotFoundException;
import com.employeeMSMS.paylode.EmployeeDto;
import com.employeeMSMS.repositry.EmployeeRepo;
import com.employeeMSMS.service.EmployeeService;


@Service
public class EmployeeServiceImpl implements EmployeeService{

	
	@Autowired
	private EmployeeRepo employeeRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		// TODO Auto-generated method stub
		Employee employee=this.modelMapper.map(employeeDto, Employee.class);
	employee.setZmageName("defalut.png");
		Employee createEmployee=this.employeeRepo.save(employee);
		return this.modelMapper.map(createEmployee, EmployeeDto.class);
	}

	@Override
	public EmployeeDto updateEmployee(EmployeeDto employeeDto, Integer employeeId) {
		// TODO Auto-generated method stub
		Employee employee=this.employeeRepo.findById(employeeId).orElseThrow(()-> new ResourceNotFoundException("Employee", "Id", employeeId));
		
		employee.setName(employeeDto.getName());
		employee.setEmail(employeeDto.getEmail());
		//employee.setPassword(employeeDto.getPassword());
//		employee.setImageName(employeeDto.getImageName());
		employee.setZmageName(employeeDto.getZmageName());
		employee.setSalary(employeeDto.getSalary());
		employee.setAddress(employeeDto.getAddress());
		employee.setCategory(employeeDto.getCategory());
		
		Employee updateEmployee=this.employeeRepo.save(employee);
		return this.modelMapper.map(updateEmployee, EmployeeDto.class);
	}

	@Override
	public void deleteEmployee(Integer employeeId) {
		// TODO Auto-generated method stub
		Employee employee=this.employeeRepo.findById(employeeId).orElseThrow(()-> new ResourceNotFoundException("Employee", "Id", employeeId));
 
		this.employeeRepo.delete(employee);
		
	}

	@Override
	public EmployeeDto getEmployeeId(Integer employeeId) {
		// TODO Auto-generated method stub
		Employee employee=this.employeeRepo.findById(employeeId).orElseThrow(()-> new ResourceNotFoundException("Employee", "Id", employeeId));

		return this.modelMapper.map(employee, EmployeeDto.class);
	}

	@Override
	public List<EmployeeDto> getAllemployee() {
		// TODO Auto-generated method stub
		List<Employee> employees=this.employeeRepo.findAll();
		List<EmployeeDto> getAllEmployee=employees.stream().map((em)-> this.modelMapper.map(em, EmployeeDto.class)).collect(Collectors.toList());
		return getAllEmployee;
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
	
		return employeeRepo.count();
	}

	@Override
	public Double total() {
		// TODO Auto-generated method stub
		List<Employee> employees=this.employeeRepo.findAll();
        return employees.stream().mapToDouble(Employee::getSalary).sum();

		
	}

	
	
	

}
