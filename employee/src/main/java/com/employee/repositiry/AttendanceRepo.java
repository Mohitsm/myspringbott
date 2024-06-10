package com.employee.repositiry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.entity.Attendance;




public interface AttendanceRepo extends JpaRepository<Attendance, Long> {

}
