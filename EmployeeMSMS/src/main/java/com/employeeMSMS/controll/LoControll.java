package com.employeeMSMS.controll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employeeMSMS.paylode.LoDto;
import com.employeeMSMS.service.LoService;

@RestController
@RequestMapping("/lo")
public class LoControll {
	
	@Autowired
	private LoService loService;
	
	
	@PostMapping("/")
	public ResponseEntity<List<LoDto>> createLo(@RequestBody List<LoDto> loDtos){
		List<LoDto> loDto=this.loService.createLo(loDtos);
		return new ResponseEntity<List<LoDto>>(loDto,HttpStatus.CREATED);
	}

}
