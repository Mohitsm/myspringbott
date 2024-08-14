package com.employee.repositiry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.entity.Attendance;



@Repository
public interface AttendanceRepo extends JpaRepository<Attendance, Long> {
//	List<Attendance> findByEmployeelId(Long employeelId);

}
