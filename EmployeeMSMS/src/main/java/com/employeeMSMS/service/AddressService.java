package com.employeeMSMS.service;

import java.util.List;

import com.employeeMSMS.paylode.AddressDto;

public interface AddressService {
	AddressDto createAddress(AddressDto addressDto);
	AddressDto updateAddress(AddressDto addressDto,Integer addtressId);
	void deleteAddress(Integer addtressId);
	AddressDto getAddressById(Integer addtressId);
	List<AddressDto> getAllAddress();

}
