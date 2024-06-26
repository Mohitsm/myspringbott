package com.employee.repositiry;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.employee.dto.EmployeeDto;
import com.employee.entity.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long>{
	
	

}
