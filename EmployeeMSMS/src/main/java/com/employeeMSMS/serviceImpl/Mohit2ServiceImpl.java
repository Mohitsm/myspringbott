package com.employeeMSMS.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeeMSMS.entity.Mohit1;
import com.employeeMSMS.entity.Mohit2;
import com.employeeMSMS.exception.ResourceNotFoundException;
import com.employeeMSMS.paylode.MohitDto;
import com.employeeMSMS.repositry.Mohit2Repo;
import com.employeeMSMS.repositry.Mohit2Repo;
import com.employeeMSMS.service.Mohit2Service;

@Service
public class Mohit2ServiceImpl implements Mohit2Service {

	@Autowired
	private Mohit2Repo mohit2Repo;
	
	@Autowired
	private ModelMapper modelMapper;
	@Override
	public MohitDto createMohit(MohitDto mohitDto) {
		// TODO Auto-generated method stub
		Mohit2 Mohit2=this.modelMapper.map(mohitDto, Mohit2.class);
		Mohit2 createMohit2=this.mohit2Repo.save(Mohit2);
		return this.modelMapper.map(createMohit2, MohitDto.class);
		
	}

	@Override
	public MohitDto updateMohit(MohitDto mohitDto, Integer mohit2Id) {
		// TODO Auto-generated method stub
		Mohit2 mohit1=this.mohit2Repo.findById(mohit2Id).orElseThrow(()-> new ResourceNotFoundException("MOhit1", "Id", mohit2Id));
		mohit1.setEmail(mohitDto.getEmail());
		mohit1.setPhoneNo(mohitDto.getPhoneNo());
		
		Mohit2 updateMohit1=this.mohit2Repo.save(mohit1);

		return this.modelMapper.map(updateMohit1, MohitDto.class);
	}

	@Override
	public void deleteMohit(Integer mohit2Id) {
		// TODO Auto-generated method stub
		Mohit2 mohit1=this.mohit2Repo.findById(mohit2Id).orElseThrow(()-> new ResourceNotFoundException("MOhit1", "Id", mohit2Id));

		this.mohit2Repo.delete(mohit1);

	}

	@Override
	public MohitDto getMohitById(Integer mohit2Id) {
		// TODO Auto-generated method stub
		Mohit2 mohit1=this.mohit2Repo.findById(mohit2Id).orElseThrow(()-> new ResourceNotFoundException("MOhit1", "Id", mohit2Id));

		
		return this.modelMapper.map(mohit1, MohitDto.class);
	}

	@Override
	public List<MohitDto> getAllMohit() {
		// TODO Auto-generated method stub
		List<Mohit2> mohit1s=this.mohit2Repo.findAll();
		List<MohitDto> getAllMohit=mohit1s.stream().map((mo)->this.modelMapper.map(mo, MohitDto.class)).collect(Collectors.toList());
		return getAllMohit;
	}

}
