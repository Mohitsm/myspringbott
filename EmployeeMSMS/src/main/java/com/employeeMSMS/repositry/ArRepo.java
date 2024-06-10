package com.employeeMSMS.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employeeMSMS.entity.Ar;

public interface ArRepo extends JpaRepository<Ar, Integer>{
	long countByStatus(String status);

}
