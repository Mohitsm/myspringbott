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

import com.employeeMSMS.paylode.AddressDto;
import com.employeeMSMS.paylode.ApiResponse;
import com.employeeMSMS.service.AddressService;

@RestController
@RequestMapping("/api/address")
public class AddressControll {
	
	@Autowired
	private AddressService addressService;
	
	//create
	@PostMapping("/")
	public ResponseEntity<AddressDto> createAddress(@RequestBody AddressDto addressDto){
		AddressDto addressDto2=this.addressService.createAddress(addressDto);
		return new ResponseEntity<AddressDto>(addressDto2,HttpStatus.CREATED);
	}
	//update
	@PutMapping("/{addressId}")
	public ResponseEntity<AddressDto> updateAddress(@RequestBody AddressDto addressDto,@PathVariable Integer addressId){
		AddressDto updateAddress=this.addressService.updateAddress(addressDto, addressId);
		return ResponseEntity.ok(updateAddress);
	}
	//delete
	@DeleteMapping("/{addressId}")
	public ResponseEntity<ApiResponse> deleteAddress(@PathVariable Integer addressId){
		this.addressService.deleteAddress(addressId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("category is deleted successfully !!", true),
				HttpStatus.OK);
	}
	
	//getById
	@GetMapping("/{addressId}")
	public ResponseEntity<AddressDto> getAddressById(@PathVariable Integer addressId){
		return ResponseEntity.ok(this.addressService.getAddressById(addressId));
	}
	
	//getAll
	@GetMapping("/")
	public ResponseEntity<List<AddressDto>> getAllAddress(){
		return ResponseEntity.ok(this.addressService.getAllAddress());
	}
	

}
