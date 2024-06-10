package com.employeeMSMS.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.employeeMSMS.entity.Excel;
import com.employeeMSMS.helper.Helper;
import com.employeeMSMS.helper.Helpere;
import com.employeeMSMS.repositry.ExcelRepo;

@Service
public class ExcelService {
	
	@Autowired
	 private ExcelRepo excelRepo;
	
	
	
	public void save(MultipartFile file) {
		
		try {
			List<Excel> excels=Helpere.converExcelToList(file.getInputStream());
			this.excelRepo.saveAll(excels);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Excel> getAllExcel(){
		return this.excelRepo.findAll();
		
	}

}
