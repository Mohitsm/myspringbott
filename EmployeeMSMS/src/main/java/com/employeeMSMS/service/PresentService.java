package com.employeeMSMS.service;

import java.util.List;

import com.employeeMSMS.paylode.PresentDto;

public interface PresentService {
	PresentDto createPresent(PresentDto presentDto);
	PresentDto updatePresent(PresentDto presentDto,Integer presentId);
	void deletePresent(Integer presentId);
	PresentDto getPresentById(Integer presentId);
	List<PresentDto> getAllPresent();

}
