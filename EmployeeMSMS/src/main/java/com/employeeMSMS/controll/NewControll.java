package com.employeeMSMS.controll;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.employeeMSMS.service.NewSErvice;

@RestController
@RequestMapping("/api/new")
public class NewControll {
	
	@Autowired
	private NewSErvice newSErvice;
	
	@Value("${project.image}")
	private String path;
	@PostMapping("/upload")
    public ResponseEntity<String> uploadEmployeeDetails(@RequestParam("name") String name,
                                                        @RequestParam("file") MultipartFile file) {
        try {
            newSErvice.uploadEmployeeDetails(path, file);
            return ResponseEntity.ok("Employee details uploaded successfully!");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload employee details");
        }
    }

}
