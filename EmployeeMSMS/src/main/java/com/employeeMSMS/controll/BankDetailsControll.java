package com.employeeMSMS.controll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employeeMSMS.paylode.AdvanceDetailsDto;
import com.employeeMSMS.paylode.ApiResponse;
import com.employeeMSMS.paylode.BankDetailsDto;
import com.employeeMSMS.service.BankDetailsService;

@RestController
@RequestMapping("/api/bankDetails")
public class BankDetailsControll {
	
	@Autowired
	private BankDetailsService bankDetailsService;
	
	//create
	@PostMapping("/")
	public ResponseEntity<BankDetailsDto> createBankDetails(@RequestBody BankDetailsDto bankDetailsDto){
		BankDetailsDto createBankDetails=this.bankDetailsService.createBankDetails(bankDetailsDto);
		return new ResponseEntity<BankDetailsDto>(createBankDetails,HttpStatus.CREATED);
	}
	
	//update
	@PutMapping("/{bankDetailsId}")
	public ResponseEntity<BankDetailsDto> updateBankDetails(@RequestBody BankDetailsDto bankDetailsDto,@PathVariable Integer bankDetailsId){
		BankDetailsDto updateBankDetails=this.bankDetailsService.updateBankDetails(bankDetailsDto, bankDetailsId);
		return ResponseEntity.ok(updateBankDetails);
		
	}
	//delete
	@DeleteMapping("/{bankDetailsId}")
	public ResponseEntity<ApiResponse> deleteBankDetails(@PathVariable Integer bankDetailsId){
		this.bankDetailsService.deleteBankDetails(bankDetailsId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("category is deleted successfully !!", true),
				HttpStatus.OK);
	}
	
	//getById
	@GetMapping("/{bankDetailsId}")
	public ResponseEntity<BankDetailsDto> getBankDetailsById(@PathVariable Integer bankDetailsId){
		return ResponseEntity.ok(this.bankDetailsService.getBankDetailsById(bankDetailsId));
	}
	
	//getAllUser
	@GetMapping("/")
	public ResponseEntity<List<BankDetailsDto>> getAllBankDetails(){
		return ResponseEntity.ok(this.bankDetailsService.getAllBankDetails());
	}

}
