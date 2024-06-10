package com.employeeMSMS.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeeMSMS.entity.AdvanceDetails;
import com.employeeMSMS.exception.ResourceNotFoundException;
import com.employeeMSMS.paylode.AdvanceDetailsDto;
import com.employeeMSMS.repositry.AdvanceDetailsRepo;
import com.employeeMSMS.service.AdvanceDetailsService;

@Service
public class AdvanceDetailsserviceImpl implements AdvanceDetailsService {
	
	@Autowired
	private AdvanceDetailsRepo advanceDetailsRepo;
	
	@Autowired 
	private ModelMapper modelMapper;

	@Override
	public AdvanceDetailsDto createAdvanceDetails(AdvanceDetailsDto advanceDetailsDto) {
		// TODO Auto-generated method stub
		AdvanceDetails advanceDetails=this.modelMapper.map(advanceDetailsDto, AdvanceDetails.class);
		AdvanceDetails createAdvanceDetails=this.advanceDetailsRepo.save(advanceDetails);
		return this.modelMapper.map(createAdvanceDetails, AdvanceDetailsDto.class);
	}

	@Override
	public AdvanceDetailsDto updateAdvanceDetails(AdvanceDetailsDto advanceDetailsDto, Integer advanceDetailsId) {
		// TODO Auto-generated method stub
		AdvanceDetails advanceDetails=this.advanceDetailsRepo.findById(advanceDetailsId).orElseThrow(()-> new ResourceNotFoundException("AdvanceDetails", "Id", advanceDetailsId));
		return null;
	}

	@Override
	public void deleteAdvanceDetails(Integer advanceDetailsId) {
		// TODO Auto-generated method stub
		AdvanceDetails advanceDetails=this.advanceDetailsRepo.findById(advanceDetailsId).orElseThrow(()-> new ResourceNotFoundException("AdvanceDetails", "Id", advanceDetailsId));

		this.advanceDetailsRepo.delete(advanceDetails);

	}

	@Override
	public AdvanceDetailsDto getAdvanceDetailsById(Integer advanceDetailsId) {
		// TODO Auto-generated method stub
		AdvanceDetails advanceDetails=this.advanceDetailsRepo.findById(advanceDetailsId).orElseThrow(()-> new ResourceNotFoundException("AdvanceDetails", "Id", advanceDetailsId));

		
		return this.modelMapper.map(advanceDetails, AdvanceDetailsDto.class);
	}

	@Override
	public List<AdvanceDetailsDto> getAllAdvanceDetails() {
		// TODO Auto-generated method stub
		List<AdvanceDetails> advanceDetails=this.advanceDetailsRepo.findAll();
		List<AdvanceDetailsDto> getaAllAdvanceDetailsDtos=advanceDetails.stream().map((ad)-> this.modelMapper.map(ad, AdvanceDetailsDto.class)).collect(Collectors.toList());
		return getaAllAdvanceDetailsDtos;
	}

}
