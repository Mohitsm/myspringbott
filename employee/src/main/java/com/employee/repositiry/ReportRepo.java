package com.employee.repositiry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.entity.Report;




public interface ReportRepo extends JpaRepository<Report, Long>{

}
