package com.employee.repositiry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.entity.PayEmployee;



public interface PayEmployeeRepo extends JpaRepository<PayEmployee, Long> {

}
