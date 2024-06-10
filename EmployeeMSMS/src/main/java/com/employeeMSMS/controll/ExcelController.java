package com.employeeMSMS.controll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.employeeMSMS.service.ExcelService;
import com.employeeMSMS.service.ExcelServices;

@RestController
public class ExcelController {

    @Autowired
    private ExcelServices excelService;
    
    @Autowired
    private ExcelService excelService2;

    @PostMapping("/moh")
    public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file) {
        try {
            excelService2.save(file);
            return ResponseEntity.ok("Data uploaded successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error uploading data: " + e.getMessage());
        }
    }
}