package com.employeeMSMS.service;

import java.util.List;

import com.employeeMSMS.paylode.QualificationDto;

public interface QualificationService {
	
	QualificationDto createQualification(QualificationDto qualificationDto);
	QualificationDto updateQualification(QualificationDto qualificationDto,Integer qualificationId);
	void deleteQualification(Integer qualificationId);
	QualificationDto getQualificationById(Integer qualificationId);
	List<QualificationDto> getaAllQualification();

}
