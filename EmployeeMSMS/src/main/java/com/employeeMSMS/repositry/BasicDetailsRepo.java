package com.employeeMSMS.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employeeMSMS.entity.BasicDetails;

public interface BasicDetailsRepo extends JpaRepository<BasicDetails, Integer> {

}
