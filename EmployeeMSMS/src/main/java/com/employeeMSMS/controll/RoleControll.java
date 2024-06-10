package com.employeeMSMS.controll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employeeMSMS.paylode.EmployeeDto;
import com.employeeMSMS.paylode.RoleDto;
import com.employeeMSMS.service.RoleService;

@RestController
@RequestMapping("/api/role")
public class RoleControll {
	
	@Autowired
	private RoleService roleService;
	
	//create
	@PostMapping("/")
	public ResponseEntity<RoleDto> createRole(@RequestBody RoleDto roleDto){
		RoleDto createRole=this.roleService.createRole(roleDto);
		return  new ResponseEntity<RoleDto>(createRole,HttpStatus.CREATED);
	}

	//get
	@GetMapping("/{roleId}")
	public ResponseEntity<RoleDto> getRoleById(@PathVariable Integer roleId){
		RoleDto getRole=this.roleService.getRoleById(roleId);
		return ResponseEntity.ok(getRole);
	}
	//getAll
	 @GetMapping("/count")
	    public String getEmployeeCount() {
	        long maleCount = roleService.countMaleEmployees();
	        long femaleCount = roleService.countFemaleEmployees();
	        long roleCount=roleService.count();
	        return "Male Employees: " + maleCount + ", Female Employees: " + femaleCount+",role count:"+roleCount;
	    }
	 @GetMapping("/")
		public ResponseEntity<List<RoleDto>> getAllEmployee(){
			return ResponseEntity.ok(this.roleService.getAllRole());
		}
	 @GetMapping("/counts")
	 public ResponseEntity<Long> count() {
        long count = roleService.count();
        return ResponseEntity.ok(count);
    }
	 @GetMapping("/countm")
	 public ResponseEntity<Long> countMaleEmployees() {
        long count = roleService.countMaleEmployees();
        return ResponseEntity.ok(count);
    }
	 @GetMapping("/countf")
	 public ResponseEntity<Long> countFemaleEmployees() {
        long count = roleService.countFemaleEmployees();
        return ResponseEntity.ok(count);
    }
	 @GetMapping("/countt")
	 public ResponseEntity<Long> countTransEmployees() {
        long count = roleService.countTransEmployees();
        return ResponseEntity.ok(count);
    }
	 
}
