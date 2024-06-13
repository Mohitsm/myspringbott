package com.employee.serviceImpl;

import java.util.List;


import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.entity.AddPayment;
import com.employee.exception.ResourceNotFoundException;
import com.employee.dto.AddPaymentDto;
import com.employee.repositiry.AddPaaymentRepo;
import com.employee.service.AddPaymentService;
@Service
public class AddPaymentServiceImp implements AddPaymentService {
	
	@Autowired
	private AddPaaymentRepo addPaaymentRepo;
	
	@Autowired 
	private ModelMapper modelMapper;

	@Override
	public AddPaymentDto createAddPayment(AddPaymentDto addPaymentDto) {
		// TODO Auto-generated method stub
		AddPayment addPayment=this.modelMapper.map(addPaymentDto, AddPayment.class);
		AddPayment createAddPayment=this.addPaaymentRepo.save(addPayment);
		return this.modelMapper.map(createAddPayment, AddPaymentDto.class);
	}

	@Override
	public AddPaymentDto updateAddPayment(AddPaymentDto addPaymentDto, Long addPaymentId) {
		// TODO Auto-generated method stub
		AddPayment addPayment=this.addPaaymentRepo.findById(addPaymentId).orElseThrow(()->new ResourceNotFoundException("AddPayment", "Id", addPaymentId));
		
		addPayment.setName(addPaymentDto.getName());
		addPayment.setUsername(addPaymentDto.getUsername());
		addPayment.setEmail(addPaymentDto.getEmail());
		AddPayment updateAddPayment=this.addPaaymentRepo.save(addPayment);
		return this.modelMapper.map(updateAddPayment, AddPaymentDto.class);
	}

	@Override
	public void deleteAddPayment(Long addPaymentId) {
		// TODO Auto-generated method stub
		AddPayment addPayment=this.addPaaymentRepo.findById(addPaymentId).orElseThrow(()->new ResourceNotFoundException("AddPayment", "Id", addPaymentId));

		this.addPaaymentRepo.delete(addPayment);
		
	}

	@Override
	public AddPaymentDto getAddPaymentId(Long addPaymentId) {
		// TODO Auto-generated method stub
		AddPayment addPayment=this.addPaaymentRepo.findById(addPaymentId).orElseThrow(()->new ResourceNotFoundException("AddPayment", "Id", addPaymentId));

		
		return this.modelMapper.map(addPayment, AddPaymentDto.class);
	}

	@Override
	public List<AddPaymentDto> getAllAddPayment() {
		// TODO Auto-generated method stub
		List<AddPayment> addPayments=this.addPaaymentRepo.findAll();
		List<AddPaymentDto> addPaymentDtos=addPayments.stream().map((ap)->this.modelMapper.map(ap, AddPaymentDto.class)).collect(Collectors.toList());
		
		return addPaymentDtos;
	}

}
