package com.employeeMSMS.service;

import java.util.List;

import com.employeeMSMS.paylode.OdDto;

public interface OdService {
	OdDto createOd(OdDto odDto);
	OdDto updateOd(OdDto odDto,Integer odId);
	void deleteOd(Integer odId);
	OdDto getOdById(Integer odId);
	List<OdDto> getAllOd();
	public long countApprovedEmployees();
	public long countPendingEmployees();
	public long countRejectedEmployees();
	public Long count();

}
