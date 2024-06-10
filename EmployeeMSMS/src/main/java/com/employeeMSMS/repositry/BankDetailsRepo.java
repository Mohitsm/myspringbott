package com.employeeMSMS.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employeeMSMS.entity.BankDetails;

public interface BankDetailsRepo extends JpaRepository<BankDetails, Integer> {

}
