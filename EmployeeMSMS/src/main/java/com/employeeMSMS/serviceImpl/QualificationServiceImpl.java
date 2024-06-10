package com.employeeMSMS.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeeMSMS.entity.Qualification;
import com.employeeMSMS.exception.ResourceNotFoundException;
import com.employeeMSMS.paylode.QualificationDto;
import com.employeeMSMS.repositry.QualificationRepo;
import com.employeeMSMS.service.QualificationService;
@Service
public class QualificationServiceImpl implements QualificationService {
	
	@Autowired
	private QualificationRepo qualificationRepo;
	
	@Autowired 
	private ModelMapper modelMapper;

	@Override
	public QualificationDto createQualification(QualificationDto qualificationDto) {
		// TODO Auto-generated method stub
		Qualification qualification=this.modelMapper.map(qualificationDto, Qualification.class);
		Qualification createQualification=this.qualificationRepo.save(qualification);
		return this.modelMapper.map(createQualification, QualificationDto.class);
	}

	@Override
	public QualificationDto updateQualification(QualificationDto qualificationDto, Integer qualificationId) {
		// TODO Auto-generated method stub
		Qualification qualification=this.qualificationRepo.findById(qualificationId).orElseThrow(()-> new ResourceNotFoundException("Qualification", "Id", qualificationId));
		return null;
	}

	@Override
	public void deleteQualification(Integer qualificationId) {
		// TODO Auto-generated method stub
		Qualification qualification=this.qualificationRepo.findById(qualificationId).orElseThrow(()-> new ResourceNotFoundException("Qualification", "Id", qualificationId));

		this.qualificationRepo.delete(qualification);

	}

	@Override
	public QualificationDto getQualificationById(Integer qualificationId) {
		// TODO Auto-generated method stub
		Qualification qualification=this.qualificationRepo.findById(qualificationId).orElseThrow(()-> new ResourceNotFoundException("Qualification", "Id", qualificationId));

		
		return this.modelMapper.map(qualification, QualificationDto.class);
	}

	@Override
	public List<QualificationDto> getaAllQualification() {
		// TODO Auto-generated method stub
		List<Qualification> qualifications=this.qualificationRepo.findAll();
		List<QualificationDto> getAllQualificationDtos=qualifications.stream().map((qu)-> this.modelMapper.map(qu, QualificationDto.class)).collect(Collectors.toList());
		
		return getAllQualificationDtos;
	}

}
