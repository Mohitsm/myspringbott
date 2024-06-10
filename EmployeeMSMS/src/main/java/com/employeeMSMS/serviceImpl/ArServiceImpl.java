package com.employeeMSMS.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeeMSMS.entity.Ar;
import com.employeeMSMS.exception.ResourceNotFoundException;
import com.employeeMSMS.paylode.ArDto;
import com.employeeMSMS.repositry.ArRepo;
import com.employeeMSMS.service.ArService;
@Service
public class ArServiceImpl implements ArService {
	
	@Autowired
	private ArRepo arRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public ArDto createAr(ArDto arDto) {
		// TODO Auto-generated method stub
		Ar ar=this.modelMapper.map(arDto, Ar.class);
		Ar createAr=this.arRepo.save(ar);
		return this.modelMapper.map(createAr, ArDto.class);
	}

	@Override
	public ArDto updateAr(ArDto arDto, Integer arId) {
		// TODO Auto-generated method stub
		Ar ar=this.arRepo.findById(arId).orElseThrow(()-> new ResourceNotFoundException("Ar","Id", arId));
		ar.setStatus(arDto.getStatus());
		Ar updateAr=this.arRepo.save(ar);
		return this.modelMapper.map(updateAr, ArDto.class);
	}

	@Override
	public void deleteAr(Integer arId) {
		// TODO Auto-generated method stub
		Ar ar=this.arRepo.findById(arId).orElseThrow(()-> new ResourceNotFoundException("Ar","Id", arId));

	}

	@Override
	public ArDto getArById(Integer arId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ArDto> getAllAr() {
		// TODO Auto-generated method stub
		List<Ar> ars=this.arRepo.findAll();
		List<ArDto> getAllAr=ars.stream().map((ks)->this.modelMapper.map(ks, ArDto.class)).collect(Collectors.toList());
		return getAllAr;
	}

	@Override
	public long countApprovedEmployees() {
		// TODO Auto-generated method stub
		return this.arRepo.countByStatus("Approved");
	}

	@Override
	public long countPendingEmployees() {
		// TODO Auto-generated method stub
		return this.arRepo.countByStatus("Pending");
	}

	@Override
	public long countRejectedEmployees() {
		// TODO Auto-generated method stub
		return this.arRepo.countByStatus("Rejected");
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return arRepo.count();
	}

}
