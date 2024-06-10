package com.employeeMSMS.service;

import java.util.List;

import com.employeeMSMS.paylode.AdvanceDetailsDto;

public interface AdvanceDetailsService {
	
	AdvanceDetailsDto createAdvanceDetails(AdvanceDetailsDto advanceDetailsDto);
	AdvanceDetailsDto updateAdvanceDetails(AdvanceDetailsDto advanceDetailsDto,Integer advanceDetailsId);
	void deleteAdvanceDetails(Integer advanceDetailsId);
	AdvanceDetailsDto getAdvanceDetailsById(Integer advanceDetailsId);
	List<AdvanceDetailsDto> getAllAdvanceDetails();

}
