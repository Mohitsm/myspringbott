package com.employeeMSMS.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeeMSMS.entity.BankDetails;
import com.employeeMSMS.exception.ResourceNotFoundException;
import com.employeeMSMS.paylode.BankDetailsDto;
import com.employeeMSMS.repositry.BankDetailsRepo;
import com.employeeMSMS.service.BankDetailsService;

@Service
public class BankDetailsServiceImpl implements BankDetailsService {
	
	@Autowired
	private BankDetailsRepo bankDetailsRepo;
	
	@Autowired 
	private ModelMapper modelMapper;

	@Override
	public BankDetailsDto createBankDetails(BankDetailsDto bankDetailsDto) {
		// TODO Auto-generated method stub
		BankDetails bankDetails=this.modelMapper.map(bankDetailsDto, BankDetails.class);
		BankDetails createBankDetails=this.bankDetailsRepo.save(bankDetails);
		return this.modelMapper.map(createBankDetails, BankDetailsDto.class);
	}

	@Override
	public BankDetailsDto updateBankDetails(BankDetailsDto bankDetailsDto, Integer bankDetailsId) {
		// TODO Auto-generated method stub
		BankDetails bankDetails=this.bankDetailsRepo.findById(bankDetailsId).orElseThrow(()-> new ResourceNotFoundException("BankDetails", "Id", bankDetailsId));
		
		return null;
	}

	@Override
	public void deleteBankDetails(Integer bankDetailsId) {
		// TODO Auto-generated method stub
		BankDetails bankDetails=this.bankDetailsRepo.findById(bankDetailsId).orElseThrow(()-> new ResourceNotFoundException("BankDetails", "Id", bankDetailsId));

		this.bankDetailsRepo.delete(bankDetails);

	}

	@Override
	public BankDetailsDto getBankDetailsById(Integer bankDetailsId) {
		// TODO Auto-generated method stub
		BankDetails bankDetails=this.bankDetailsRepo.findById(bankDetailsId).orElseThrow(()-> new ResourceNotFoundException("BankDetails", "Id", bankDetailsId));

		
		return this.modelMapper.map(bankDetails, BankDetailsDto.class);
	}

	@Override
	public List<BankDetailsDto> getAllBankDetails() {
		// TODO Auto-generated method stub
		List<BankDetails> bankDetails=this.bankDetailsRepo.findAll();
		List<BankDetailsDto> getAllBankDetailsDtos=bankDetails.stream().map((bd)-> this.modelMapper.map(bd, BankDetailsDto.class)).collect(Collectors.toList());
		return getAllBankDetailsDtos;
	}

}
