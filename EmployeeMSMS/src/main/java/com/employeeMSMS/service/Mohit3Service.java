package com.employeeMSMS.service;

import java.util.List;

import com.employeeMSMS.paylode.MohitDto;

public interface Mohit3Service {
	MohitDto createMohit(MohitDto mohitDto);
	MohitDto updateMohit(MohitDto mohitDto,Integer mohit3Id);
	void deleteMohit(Integer mohit3Id);
	MohitDto getMohitById(Integer mohit3Id);
	List<MohitDto> getAllMohit();

}
