package com.employeeMSMS.service;

import java.util.List;

import com.employeeMSMS.paylode.FamilyDetailsDto;

public interface FamilyDetailsService {
	

	FamilyDetailsDto createFamilyDetails(FamilyDetailsDto familyDetailsDto);
	FamilyDetailsDto updateFamilyDetails(FamilyDetailsDto familyDetailsDto,Integer familyDetailsId);
	void deleteFamilyDetails(Integer familyDetailsId);
	FamilyDetailsDto getFamilyDetailsById(Integer familyDetailsId);
	List<FamilyDetailsDto> getAllFamilyDetails();
	
}
