package com.employeeMSMS.service;

import java.util.List;

import com.employeeMSMS.paylode.MohitDto;

public interface Mohit1Service {
	
	MohitDto createMohit(MohitDto mohitDto);
	MohitDto updateMohit(MohitDto mohitDto,Integer mohit1Id);
	void deleteMohit(Integer mohit1Id);
	MohitDto getMohitById(Integer mohit1Id);
	List<MohitDto> getAllMohit();
	

}
