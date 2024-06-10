package com.employeeMSMS.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeeMSMS.entity.Od;
import com.employeeMSMS.paylode.OdDto;
import com.employeeMSMS.repositry.OdRepo;
import com.employeeMSMS.service.OdService;
@Service
public class OdServiceImpl implements OdService {
	
	@Autowired
	private OdRepo odRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public OdDto createOd(OdDto odDto) {
		// TODO Auto-generated method stub
		Od od=this.modelMapper.map(odDto, Od.class);
		Od createOd=this.odRepo.save(od);
		return this.modelMapper.map(createOd, OdDto.class);
	}

	@Override
	public OdDto updateOd(OdDto odDto, Integer odId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteOd(Integer odId) {
		// TODO Auto-generated method stub

	}

	@Override
	public OdDto getOdById(Integer odId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OdDto> getAllOd() {
		// TODO Auto-generated method stub
		List<Od> ods=this.odRepo.findAll();
		List<OdDto> getAllOd=ods.stream().map((lk)->this.modelMapper.map(lk, OdDto.class)).collect(Collectors.toList());
		return getAllOd;
	}

	@Override
	public long countApprovedEmployees() {
		// TODO Auto-generated method stub
		return  this.odRepo.countByStatus("Approved");
	}

	@Override
	public long countPendingEmployees() {
		// TODO Auto-generated method stub
		return this.odRepo.countByStatus("Pending");
	}

	@Override
	public long countRejectedEmployees() {
		// TODO Auto-generated method stub
		return this.odRepo.countByStatus("Rejected");
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return odRepo.count();
	}

}
