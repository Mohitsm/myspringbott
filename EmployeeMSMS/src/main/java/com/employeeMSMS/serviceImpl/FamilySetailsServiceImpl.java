package com.employeeMSMS.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeeMSMS.entity.FamilyDetails;
import com.employeeMSMS.exception.ResourceNotFoundException;
import com.employeeMSMS.paylode.FamilyDetailsDto;
import com.employeeMSMS.repositry.FamilyDetailsRepo;
import com.employeeMSMS.service.FamilyDetailsService;
@Service
public class FamilySetailsServiceImpl implements FamilyDetailsService {
	@Autowired
	private FamilyDetailsRepo familyDetailsRepo;
	
	@Autowired 
	private ModelMapper modelMapper;

	@Override
	public FamilyDetailsDto createFamilyDetails(FamilyDetailsDto familyDetailsDto) {
		// TODO Auto-generated method stub
		FamilyDetails familyDetails=this.modelMapper.map(familyDetailsDto, FamilyDetails.class);
		FamilyDetails createFamilyDetails=this.familyDetailsRepo.save(familyDetails);
		return this.modelMapper.map(createFamilyDetails, FamilyDetailsDto.class);
	}

	@Override
	public FamilyDetailsDto updateFamilyDetails(FamilyDetailsDto familyDetailsDto, Integer familyDetailsId) {
		// TODO Auto-generated method stub
		FamilyDetails familyDetails=this.familyDetailsRepo.findById(familyDetailsId).orElseThrow(()-> new ResourceNotFoundException("FamilyDetailsDto", "ID", familyDetailsId));
		return null;
	}

	@Override
	public void deleteFamilyDetails(Integer familyDetailsId) {
		// TODO Auto-generated method stub
		FamilyDetails familyDetails=this.familyDetailsRepo.findById(familyDetailsId).orElseThrow(()-> new ResourceNotFoundException("FamilyDetailsDto", "ID", familyDetailsId));

		this.familyDetailsRepo.delete(familyDetails);

	}

	@Override
	public FamilyDetailsDto getFamilyDetailsById(Integer familyDetailsId) {
		// TODO Auto-generated method stub
		FamilyDetails familyDetails=this.familyDetailsRepo.findById(familyDetailsId).orElseThrow(()-> new ResourceNotFoundException("FamilyDetailsDto", "ID", familyDetailsId));

		return this.modelMapper.map(familyDetails,FamilyDetailsDto.class);
	}

	@Override
	public List<FamilyDetailsDto> getAllFamilyDetails() {
		// TODO Auto-generated method stub
		List<FamilyDetails> familyDetails=this.familyDetailsRepo.findAll();
		List<FamilyDetailsDto> getAllFamilyDetailsDtos=familyDetails.stream().map((fd)-> this.modelMapper.map(fd, FamilyDetailsDto.class)).collect(Collectors.toList());
		return getAllFamilyDetailsDtos;
	}

}
