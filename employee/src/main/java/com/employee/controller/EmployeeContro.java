package com.employee.controller;

import java.io.IOException;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.employee.dto.ApiResponse;
import com.employee.dto.EmployeeDto;
import com.employee.dto.FileResponse;
import com.employee.entity.Employee;
import com.employee.service.EmployeeService;
import com.employee.service.FileService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;



@RestController
@RequestMapping("/api/employee")

public class EmployeeContro {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	@Autowired
	private FileService fileService;
	
	@Value("${project.image}")
	private String path;
	
	//create
	@PostMapping("/")
	public ResponseEntity<?> addImage(@RequestParam("userData") String image,@RequestParam("file") MultipartFile file  ) throws JsonMappingException, JsonProcessingException{
//		logger.info("file name {}",file.getOriginalFilename());
//		logger.info("image:{}",image);
		
		Employee employee=this.objectMapper.readValue(image, Employee.class);
		EmployeeDto employeeDto=modelMapper.map(employee, EmployeeDto.class);
		employeeDto.setZmageName(file.getOriginalFilename());
		EmployeeDto employee2=this.employeeService.createEmployee(employeeDto);
		
		String fileName;
		try {
			fileName = this.fileService.uplodeImage(path, file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<FileResponse>(new FileResponse(null,"Image is successfully not uplodeed !!"), HttpStatus.OK);

		}
//		Employee employee=this.objectMapper.readValue(image, Employee.class);
//		employee.setZName(fileName);
//		Employee employee2=this.employeeService.createEmployee(employee);
		
		
		
		return new ResponseEntity<FileResponse>(new FileResponse(fileName,"Image is successfully uplodeed !!"), HttpStatus.OK);
	}
	
	
	
//	@PostMapping("/")
//	public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
//		EmployeeDto createEmployeeDto=this.employeeService.createEmployee(employeeDto);
//		return new ResponseEntity<EmployeeDto>(createEmployeeDto,HttpStatus.CREATED);
//	}
	//update
		@PutMapping("{employeeId}")
		public ResponseEntity<EmployeeDto> updateEmployee(@RequestBody EmployeeDto employeeDto,@PathVariable Long employeeId){
			EmployeeDto updateUser=this.employeeService.updateEmployee(employeeDto, employeeId);
			
			return  ResponseEntity.ok(updateUser);
		}
		
	
		//delete
		@DeleteMapping("/{employeeId}")
		public ResponseEntity<ApiResponse> deleteEmployee(@PathVariable Long employeeId){
			this.employeeService.deleteEmployee(employeeId);
			return new ResponseEntity<ApiResponse>(new ApiResponse("category is deleted successfully !!", true),
					HttpStatus.OK);
		}
		//getByID
		@GetMapping("/{employeeId}")
		public ResponseEntity<EmployeeDto> getEmployeeBId(@PathVariable Long employeeId){
			return ResponseEntity.ok(this.employeeService.getEmployeeId(employeeId));
		}
		
		//getAll
		@GetMapping("/")
		public ResponseEntity<List<EmployeeDto>> getAllEmployee(){
			return ResponseEntity.ok(this.employeeService.getAllemployee());
		}
		//count
		@GetMapping("/count")
		 public ResponseEntity<Long> count() {
	        long count = employeeService.count();
	        return ResponseEntity.ok(count);
	    }
		
		@GetMapping("/total")
		 public ResponseEntity<Double> total(){
			 Double total=employeeService.total();
			 return ResponseEntity.ok(total);
		 }
		
		@GetMapping("/countm")
		public ResponseEntity<Long> countByMale(){
			return ResponseEntity.ok(this.employeeService.getMaleEmployeeCount());

		}
		@GetMapping("/countf")
		public ResponseEntity<Long> countByFemale(){
			return ResponseEntity.ok(this.employeeService.geFetmaleEmployeeCount());

		}
		@GetMapping("/countt")
		public ResponseEntity<Long> countByTrans(){
			return ResponseEntity.ok(this.employeeService.getTransEmployeeCount());

		}
		@GetMapping("/countc")
		public ResponseEntity<Long> countBycurrent(){
			return ResponseEntity.ok(this.employeeService.getCurrentEmployees());

		}

		@GetMapping("/countex")
		public ResponseEntity<Long> countByExEmployee(){
			return ResponseEntity.ok(this.employeeService.getExEmployeeEmployees());

		}

		@GetMapping("/countexit")
		public ResponseEntity<Long> countByExitedEmployee(){
			return ResponseEntity.ok(this.employeeService.getExitedEmployeeEmployees());

		}

		@GetMapping("/countn")
		public ResponseEntity<Long> countByNewjoining(){
			return ResponseEntity.ok(this.employeeService.getNewjoiningEmployees());

		}

		@GetMapping("/countti")
		public ResponseEntity<Long> countByTransferredIn(){
			return ResponseEntity.ok(this.employeeService.getTransferredInEmployees());

		}

		@GetMapping("/countto")
		public ResponseEntity<Long> countByTransferredOut(){
			return ResponseEntity.ok(this.employeeService.getTransferredOutEmployees());

		}

		

}
