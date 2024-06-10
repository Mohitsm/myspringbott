package com.employeeMSMS.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employeeMSMS.entity.Attendance;

@Repository
public interface AttendanceRepo extends JpaRepository<Attendance, Integer>{

}
