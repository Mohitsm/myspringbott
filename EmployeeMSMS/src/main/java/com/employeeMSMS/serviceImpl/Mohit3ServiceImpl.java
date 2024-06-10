package com.employeeMSMS.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeeMSMS.entity.Mohit2;
import com.employeeMSMS.entity.Mohit3;
import com.employeeMSMS.exception.ResourceNotFoundException;
import com.employeeMSMS.paylode.MohitDto;
import com.employeeMSMS.repositry.Mohit3Repo;
import com.employeeMSMS.service.Mohit3Service;

@Service
public class Mohit3ServiceImpl implements Mohit3Service {
	
	@Autowired
	private Mohit3Repo mohit3Repo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public MohitDto createMohit(MohitDto mohitDto) {
		// TODO Auto-generated method stub
		Mohit3 Mohit3=this.modelMapper.map(mohitDto, Mohit3.class);
		Mohit3 createMohit3=this.mohit3Repo.save(Mohit3);
		return this.modelMapper.map(createMohit3, MohitDto.class);
		
	}

	@Override
	public MohitDto updateMohit(MohitDto mohitDto, Integer mohit3Id) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				Mohit3 mohit1=this.mohit3Repo.findById(mohit3Id).orElseThrow(()-> new ResourceNotFoundException("MOhit1", "Id", mohit3Id));
				mohit1.setAddress(mohitDto.getAddress());
				mohit1.setPassword(mohitDto.getPassword());
				
				Mohit3 updateMohit1=this.mohit3Repo.save(mohit1);

				return this.modelMapper.map(updateMohit1, MohitDto.class);
	}

	@Override
	public void deleteMohit(Integer mohit3Id) {
		// TODO Auto-generated method stub
		Mohit3 mohit1=this.mohit3Repo.findById(mohit3Id).orElseThrow(()-> new ResourceNotFoundException("MOhit1", "Id", mohit3Id));

		this.mohit3Repo.delete(mohit1);

	}

	@Override
	public MohitDto getMohitById(Integer mohit3Id) {
		// TODO Auto-generated method stub
		Mohit3 mohit1=this.mohit3Repo.findById(mohit3Id).orElseThrow(()-> new ResourceNotFoundException("MOhit1", "Id", mohit3Id));

		return this.modelMapper.map(mohit1, MohitDto.class);
	}

	@Override
	public List<MohitDto> getAllMohit() {
		// TODO Auto-generated method stub
		List<Mohit3> mohit1s=this.mohit3Repo.findAll();
		List<MohitDto> getAllMohit=mohit1s.stream().map((mo)->this.modelMapper.map(mo, MohitDto.class)).collect(Collectors.toList());
		return getAllMohit;
	}

}
