package com.employee.serviceImpl;

import java.util.List;

import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.entity.PayEmployee;
import com.employee.exception.ResourceNotFoundException;
import com.employee.dto.PayEmployeeDto;
import com.employee.repositiry.PayEmployeeRepo;
import com.employee.service.PayEmployeeService;
@Service
public class PayEmployeeServiceImp implements PayEmployeeService{
	
	@Autowired
	private PayEmployeeRepo payEmployeeRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public PayEmployeeDto createPayEmployee(PayEmployeeDto payEmployeeDto) {
		// TODO Auto-generated method stub
		PayEmployee payEemployee=this.modelMapper.map(payEmployeeDto, PayEmployee.class);
		PayEmployee createEemployee=this.payEmployeeRepo.save(payEemployee);
		return this.modelMapper.map(createEemployee, PayEmployeeDto.class);
	}

	@Override
	public PayEmployeeDto upadtePayEmployee(PayEmployeeDto payEmployeeDto, Long payEmployeeId) {
		// TODO Auto-generated method stub
		PayEmployee payEemployee=this.payEmployeeRepo.findById(payEmployeeId).orElseThrow(()-> new ResourceNotFoundException("PayEmployee", "Id", payEmployeeId));
		payEemployee.setName(payEmployeeDto.getName());
		payEemployee.setUsername(payEmployeeDto.getUsername());
		payEemployee.setEmail(payEmployeeDto.getEmail());
		PayEmployee updateEemployee=this.payEmployeeRepo.save(payEemployee);
		return this.modelMapper.map(updateEemployee, PayEmployeeDto.class);
	}

	@Override
	public void deletePayEmployee(Long payEmployeeId) {
		// TODO Auto-generated method stub
		PayEmployee payEemployee=this.payEmployeeRepo.findById(payEmployeeId).orElseThrow(()-> new ResourceNotFoundException("PayEmployee", "Id", payEmployeeId));

		this.payEmployeeRepo.delete(payEemployee);
		
	}

	@Override
	public PayEmployeeDto getPayEmployeeId(Long payEmployeeId) {
		// TODO Auto-generated method stub
		PayEmployee payEemployee=this.payEmployeeRepo.findById(payEmployeeId).orElseThrow(()-> new ResourceNotFoundException("PayEmployee", "Id", payEmployeeId));

		return this.modelMapper.map(payEemployee, PayEmployeeDto.class);
	}

	@Override
	public List<PayEmployeeDto> getAllPayEmployee() {
		// TODO Auto-generated method stub
		List<PayEmployee> payEemployees=this.payEmployeeRepo.findAll();
		List<PayEmployeeDto> employeeDtos=payEemployees.stream().map((pe)->this.modelMapper.map(pe, PayEmployeeDto.class)).collect(Collectors.toList());
		return employeeDtos;
	}

}
