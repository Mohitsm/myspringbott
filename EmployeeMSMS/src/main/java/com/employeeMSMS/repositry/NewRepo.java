package com.employeeMSMS.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employeeMSMS.entity.New;

@Repository
public interface NewRepo  extends JpaRepository<New, Integer>{

}
