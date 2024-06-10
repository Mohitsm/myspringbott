package com.employeeMSMS.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employeeMSMS.entity.Leaves;

public interface LeavesRepo extends JpaRepository<Leaves, Integer> {
	long countByStatus(String status);

}
