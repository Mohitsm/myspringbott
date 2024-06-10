package com.employeeMSMS.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employeeMSMS.entity.Payment;

public interface PaymentRepo extends JpaRepository<Payment, Integer>{

}
