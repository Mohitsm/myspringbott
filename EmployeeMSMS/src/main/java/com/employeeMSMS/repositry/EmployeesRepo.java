package com.employeeMSMS.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employeeMSMS.entity.Employees;

public interface EmployeesRepo extends JpaRepository<Employees, Integer>{

}
