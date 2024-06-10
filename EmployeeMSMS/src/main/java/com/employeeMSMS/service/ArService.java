package com.employeeMSMS.service;

import java.util.List;

import com.employeeMSMS.paylode.ArDto;

public interface ArService {
	ArDto createAr(ArDto arDto);
	ArDto updateAr(ArDto arDto,Integer arId);
	void deleteAr(Integer arId);
	ArDto getArById(Integer arId);
	List<ArDto> getAllAr();
	public long countApprovedEmployees();
	public long countPendingEmployees();
	public long countRejectedEmployees();
	public Long count();

}
