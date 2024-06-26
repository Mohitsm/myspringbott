package com.employee.controller;

import java.io.IOException;
import java.util.List;



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
import com.employee.service.EmployeeService;
import com.employee.service.FileService;





@RestController
@RequestMapping("/api/employee")

public class EmployeeContro {
	
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private FileService fileService;
	
	@Value("${project.image}")
	private String path;
	
	//create
	@PostMapping("/")
	public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto,@RequestParam("image") MultipartFile image){
//		EmployeeDto createEmployeeDto=this.employeeService.createEmployee(employeeDto);
//		String fileName;
		try {
			EmployeeDto employee=new EmployeeDto();
			employee.setZmageName(image.getBytes()); // Assuming you have a byte[] field in your Employee entity for storing the image
            employeeService.createEmployee(employee);
            return ResponseEntity.ok().build();
        } catch (IOException e) {
            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to process the image");
        }
		return ResponseEntity.ok().build();
}
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

}
