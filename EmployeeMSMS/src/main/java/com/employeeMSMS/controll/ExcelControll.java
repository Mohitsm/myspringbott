package com.employeeMSMS.controll;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.employeeMSMS.entity.Excel;
import com.employeeMSMS.helper.Helper;
import com.employeeMSMS.helper.Helpere;
import com.employeeMSMS.service.ExcelService;

@RestController
@RequestMapping("/api")

public class ExcelControll {
	
	@Autowired
	private ExcelService excelService;
	
	@PostMapping("/excel")
	public ResponseEntity<?> uplode(@RequestParam("file") MultipartFile file){
		if(Helpere.chekExcelFromat(file)) {
			
			this.excelService.save(file);
			
			return ResponseEntity.ok(Map.of("massage","file is uplodeed"));
			
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("please oplode Excel file");
	}
	
	@GetMapping("/")
	public List<Excel> getAllExcel(){
		return this.excelService.getAllExcel();
	}
	

}
