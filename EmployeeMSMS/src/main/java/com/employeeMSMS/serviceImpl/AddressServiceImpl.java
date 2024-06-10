package com.employeeMSMS.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeeMSMS.entity.Address;
import com.employeeMSMS.exception.ResourceNotFoundException;
import com.employeeMSMS.paylode.AddressDto;
import com.employeeMSMS.repositry.AddressRepo;
import com.employeeMSMS.service.AddressService;
@Service
public class AddressServiceImpl implements AddressService {
	
	@Autowired
	private AddressRepo addressRepo;
	
	@Autowired 
	private ModelMapper modelMapper;

	@Override
	public AddressDto createAddress(AddressDto addressDto) {
		// TODO Auto-generated method stub
		Address address=this.modelMapper.map(addressDto, Address.class);
		Address createAddress=this.addressRepo.save(address);
		return this.modelMapper.map(createAddress, AddressDto.class);
	}

	@Override
	public AddressDto updateAddress(AddressDto addressDto, Integer addtressId) {
		// TODO Auto-generated method stub
		Address address=this.addressRepo.findById(addtressId).orElseThrow(()-> new ResourceNotFoundException("Address", "Id", addtressId));
		return null;
	}

	@Override
	public void deleteAddress(Integer addtressId) {
		// TODO Auto-generated method stub
		Address address=this.addressRepo.findById(addtressId).orElseThrow(()-> new ResourceNotFoundException("Address", "Id", addtressId));

		this.addressRepo.delete(address);

	}

	@Override
	public AddressDto getAddressById(Integer addtressId) {
		// TODO Auto-generated method stub
		Address address=this.addressRepo.findById(addtressId).orElseThrow(()-> new ResourceNotFoundException("Address", "Id", addtressId));

		return this.modelMapper.map(address, AddressDto.class);
	}

	@Override
	public List<AddressDto> getAllAddress() {
		// TODO Auto-generated method stub
		List<Address> addresses=this.addressRepo.findAll();
		List<AddressDto> getAllAddressDtos=addresses.stream().map((ad)-> this.modelMapper.map(ad, AddressDto.class)).collect(Collectors.toList());
		return getAllAddressDtos;
	}

}
