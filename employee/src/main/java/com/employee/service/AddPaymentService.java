package com.employee.service;

import java.util.List;

import com.employee.dto.AddPaymentDto;



public interface AddPaymentService {
	
	AddPaymentDto createAddPayment(AddPaymentDto addPaymentDto);
	AddPaymentDto updateAddPayment(AddPaymentDto addPaymentDto,Long addPaymentId);
	void deleteAddPayment(Long addPaymentId);
	AddPaymentDto getAddPaymentId(Long addPaymentId);
	List<AddPaymentDto> getAllAddPayment();

}
