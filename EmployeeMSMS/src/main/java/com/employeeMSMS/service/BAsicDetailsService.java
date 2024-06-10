package com.employeeMSMS.service;

import java.util.List;

import com.employeeMSMS.paylode.BasicDetailsDto;

public interface BAsicDetailsService {
	
	BasicDetailsDto createBasicDetails(BasicDetailsDto basicDetailsDto);
	BasicDetailsDto updateBasicDetails(BasicDetailsDto basicDetailsDto,Integer basicDetailsId);
	void deleteBasicDetails(Integer basicDetailsId);
	BasicDetailsDto getBasicDetailsById(Integer basicDetailsId);
	List<BasicDetailsDto> getAllBasicDetails();

}
