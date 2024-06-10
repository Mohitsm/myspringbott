package com.employeeMSMS.service;

import java.util.List;

import com.employeeMSMS.paylode.PreviousWorkDto;

public interface PreviousWorkService {
	PreviousWorkDto createPreviousWork(PreviousWorkDto previousWorkDto);
	PreviousWorkDto updatePreviousWork(PreviousWorkDto previousWorkDto,Integer previousWorkId);
	void deletePreviousWork(Integer previousWorkId);
	PreviousWorkDto getPreviousWorkById(Integer previousWorkId);
	List<PreviousWorkDto> getAllPreviousWork();

}
