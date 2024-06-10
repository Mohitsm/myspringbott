package com.employee.repositiry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.entity.CalculateSalary;



public interface CalculateSalaryRepo extends JpaRepository<CalculateSalary, Long> {

}
