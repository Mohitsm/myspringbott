package com.employeeMSMS.serviceImpl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeeMSMS.paylode.PaymentDto;
import com.employeeMSMS.repositry.PaymentRepo;
import com.employeeMSMS.service.PaymentService;
@Service
public class PaymentServiceImpl implements PaymentService {
	
	@Autowired
	private PaymentRepo paymentRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public PaymentDto createPayment(PaymentDto paymentDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PaymentDto updatePayment(PaymentDto paymentDto, Integer paymentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePayment(Integer paymentId) {
		// TODO Auto-generated method stub

	}

	@Override
	public PaymentDto getPaymentById(Integer paymentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PaymentDto> getAllPayment() {
		// TODO Auto-generated method stub
		return null;
	}

}
