package com.employeeMSMS;

import java.util.Scanner;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.MultipartResolver;

@SpringBootApplication
public class EmployeeMsmsApplication {
	
	

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		SpringApplication.run(EmployeeMsmsApplication.class, args);
		System.out.println("file name");
		String na=scanner.nextLine();
		
	}
	

	
	

	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
}
