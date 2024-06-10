package com.employeeMSMS.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeeMSMS.entity.Mohit1;
import com.employeeMSMS.exception.ResourceNotFoundException;
import com.employeeMSMS.paylode.MohitDto;
import com.employeeMSMS.repositry.Mohit1Repo;
import com.employeeMSMS.service.Mohit1Service;

@Service
public class Mohit1ServiceImpl implements Mohit1Service {
	
	@Autowired
	private Mohit1Repo mohit1Repo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public MohitDto createMohit(MohitDto mohitDto) {
		// TODO Auto-generated method stub
		Mohit1 mohit1=this.modelMapper.map(mohitDto, Mohit1.class);
		Mohit1 createMohit1=this.mohit1Repo.save(mohit1);
		
		return this.modelMapper.map(createMohit1, MohitDto.class);
	}

	@Override
	public MohitDto updateMohit(MohitDto mohitDto, Integer mohit1Id) {
		// TODO Auto-generated method stub
		Mohit1 mohit1=this.mohit1Repo.findById(mohit1Id).orElseThrow(()-> new ResourceNotFoundException("MOhit1", "Id", mohit1Id));
		mohit1.setName(mohitDto.getName());
		mohit1.setLastName(mohitDto.getLastName());
		
		Mohit1 updateMohit1=this.mohit1Repo.save(mohit1);

		return this.modelMapper.map(updateMohit1, MohitDto.class);
	}

	@Override
	public void deleteMohit(Integer mohit1Id) {
		// TODO Auto-generated method stub
		Mohit1 mohit1=this.mohit1Repo.findById(mohit1Id).orElseThrow(()-> new ResourceNotFoundException("MOhit1", "Id", mohit1Id));
		this.mohit1Repo.delete(mohit1);

	}

	@Override
	public MohitDto getMohitById(Integer mohit1Id) {
		// TODO Auto-generated method stub
		Mohit1 mohit1=this.mohit1Repo.findById(mohit1Id).orElseThrow(()-> new ResourceNotFoundException("MOhit1", "Id", mohit1Id));

		return this.modelMapper.map(mohit1, MohitDto.class);
	}

	@Override
	public List<MohitDto> getAllMohit() {
		// TODO Auto-generated method stub
		List<Mohit1> mohit1s=this.mohit1Repo.findAll();
		List<MohitDto> getAllMohit=mohit1s.stream().map((mo)->this.modelMapper.map(mo, MohitDto.class)).collect(Collectors.toList());
		return getAllMohit;
	}

}
