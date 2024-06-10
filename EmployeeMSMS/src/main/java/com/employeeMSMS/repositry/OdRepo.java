package com.employeeMSMS.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employeeMSMS.entity.Od;

public interface OdRepo extends JpaRepository<Od, Integer>{
	long countByStatus(String status);

}
