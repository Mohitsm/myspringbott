package com.employeeMSMS.service;

import java.util.List;

import com.employeeMSMS.paylode.PaymentDto;

public interface PaymentService {
	PaymentDto createPayment(PaymentDto paymentDto);
	PaymentDto updatePayment(PaymentDto paymentDto,Integer paymentId);
	void deletePayment(Integer paymentId);
	PaymentDto getPaymentById(Integer paymentId);
	List<PaymentDto> getAllPayment();
	

}
