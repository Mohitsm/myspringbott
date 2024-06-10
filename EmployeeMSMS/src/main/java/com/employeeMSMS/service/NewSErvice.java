package com.employeeMSMS.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.employeeMSMS.entity.New;
import com.employeeMSMS.repositry.NewRepo;

@Service
public class NewSErvice {
	
	@Autowired
	private NewRepo newRepo;
	
	public void uploadEmployeeDetails(String name, MultipartFile file) throws IOException {
        New employee = new New();
        employee.setName(name);
        employee.setImage(file.getBytes());
        newRepo.save(employee);
    }

}
