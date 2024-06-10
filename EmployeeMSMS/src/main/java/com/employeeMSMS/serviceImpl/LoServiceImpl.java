package com.employeeMSMS.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeeMSMS.entity.Lo;
import com.employeeMSMS.paylode.LoDto;
import com.employeeMSMS.repositry.LoRepo;
import com.employeeMSMS.service.LoService;

@Service
public class LoServiceImpl implements LoService {
	
	@Autowired
	private LoRepo loRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<LoDto> createLo(List<LoDto> dtos) {
		// TODO Auto-generated method stub
		List<Lo> los=dtos.stream().map((po)->this.modelMapper.map(po, Lo.class)).collect(Collectors.toList());
		List<Lo> createLos=this.loRepo.saveAll(los);
		List<LoDto> dtos2=createLos.stream().map((lo)->this.modelMapper.map(lo, LoDto.class)).collect(Collectors.toList());
		return dtos2;
	}

}
