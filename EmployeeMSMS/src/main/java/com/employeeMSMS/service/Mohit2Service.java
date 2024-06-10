package com.employeeMSMS.service;

import java.util.List;

import com.employeeMSMS.paylode.MohitDto;

public interface Mohit2Service {
	MohitDto createMohit(MohitDto mohitDto);
	MohitDto updateMohit(MohitDto mohitDto,Integer mohit2Id);
	void deleteMohit(Integer mohit2Id);
	MohitDto getMohitById(Integer mohit2Id);
	List<MohitDto> getAllMohit();

}
