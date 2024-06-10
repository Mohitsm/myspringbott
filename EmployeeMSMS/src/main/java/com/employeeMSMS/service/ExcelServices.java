package com.employeeMSMS.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.employeeMSMS.entity.Employees;
import com.employeeMSMS.helper.ExcelParser;
import com.employeeMSMS.repositry.EmployeesRepo;

@Service
public class ExcelServices {
	 @Autowired
	    private EmployeesRepo employeesRepo;

	    public void processExcel(MultipartFile file) throws IOException {
	        // Parse Excel file and extract data
	        List<Employees> employees = ExcelParser.parse(file.getInputStream());

	        // Save extracted data to the database
	        this.employeesRepo.saveAll(employees);
	    }

}
