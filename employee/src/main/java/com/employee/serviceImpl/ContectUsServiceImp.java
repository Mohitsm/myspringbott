package com.employee.serviceImpl;

import java.util.List;

import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.dto.ContectUsDto;
import com.employee.entity.ContectUs;
import com.employee.exception.ResourceNotFoundException;
import com.employee.repositiry.ContectUsRepo;
import com.employee.service.ContectUsService;


@Service
public class ContectUsServiceImp implements ContectUsService {
	
	@Autowired
	private ContectUsRepo contectUsRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public ContectUsDto createContectUs(ContectUsDto contectUsDto) {
		// TODO Auto-generated method stub
		ContectUs contectUs=this.modelMapper.map(contectUsDto, ContectUs.class);
		ContectUs createContectUs=this.contectUsRepo.save(contectUs);
		return this.modelMapper.map(createContectUs, ContectUsDto.class);
	}

	@Override
	public ContectUsDto updateContectUs(ContectUsDto contectUsDto, Long contectUsId) {
		// TODO Auto-generated method stub
		ContectUs contectUs=this.contectUsRepo.findById(contectUsId).orElseThrow(()-> new ResourceNotFoundException("ContectUs", "Id", contectUsId));
		
		contectUs.setName(contectUsDto.getName());
		contectUs.setUsername(contectUsDto.getUsername());
		contectUs.setEmail(contectUsDto.getEmail());
		ContectUs updateContectUs=this.contectUsRepo.save(contectUs);
		return this.modelMapper.map(updateContectUs, ContectUsDto.class);
	}

	@Override
	public void deleteContectUs(Long contectUsId) {
		// TODO Auto-generated method stub
		ContectUs contectUs=this.contectUsRepo.findById(contectUsId).orElseThrow(()-> new ResourceNotFoundException("ContectUs", "Id", contectUsId));

		this.contectUsRepo.delete(contectUs);
		
	}

	@Override
	public ContectUsDto getContectUsId(Long contectUsId) {
		// TODO Auto-generated method stub
		ContectUs contectUs=this.contectUsRepo.findById(contectUsId).orElseThrow(()-> new ResourceNotFoundException("ContectUs", "Id", contectUsId));

		
		return this.modelMapper.map(contectUs, ContectUsDto.class);
	}

	@Override
	public List<ContectUsDto> getAllContectUs() {
		// TODO Auto-generated method stub
		List<ContectUs> contectUs=this.contectUsRepo.findAll();
		List<ContectUsDto> contectUsDtos=contectUs.stream().map((cu)->this.modelMapper.map(cu, ContectUsDto.class)).collect(Collectors.toList());
		return contectUsDtos;
	}

}
