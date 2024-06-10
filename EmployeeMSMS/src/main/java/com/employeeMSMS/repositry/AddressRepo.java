package com.employeeMSMS.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employeeMSMS.entity.Address;

public interface AddressRepo extends JpaRepository<Address, Integer> {

}
