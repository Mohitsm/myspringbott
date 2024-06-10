package com.employeeMSMS.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeeMSMS.entity.Leaves;
import com.employeeMSMS.paylode.LeavesDto;
import com.employeeMSMS.repositry.LeavesRepo;
import com.employeeMSMS.service.LeavesService;
@Service
public class LeavesServiceImpl implements LeavesService {

	@Autowired 
	private LeavesRepo leavesRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	@Override
	public LeavesDto createLeaves(LeavesDto leavesDto) {
		// TODO Auto-generated method stub
		Leaves leaves=this.modelMapper.map(leavesDto, Leaves.class);
		Leaves createLeaves=this.leavesRepo.save(leaves);
		return this.modelMapper.map(createLeaves, LeavesDto.class);
	}

	@Override
	public LeavesDto updateLeaves(LeavesDto leavesDto, Integer leavesId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteLeaves(Integer leavesId) {
		// TODO Auto-generated method stub

	}

	@Override
	public LeavesDto getLeavesById(Integer leavesId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LeavesDto> getAllLeaves() {
		// TODO Auto-generated method stub
		List<Leaves> leaves=this.leavesRepo.findAll();
		List<LeavesDto> getAllLeaves=leaves.stream().map((kj)->this.modelMapper.map(kj, LeavesDto.class)).collect(Collectors.toList());
	
		return getAllLeaves;
	}

	@Override
	public long countApprovedEmployees() {
		// TODO Auto-generated method stub
		return this.leavesRepo.countByStatus("Approved");
	}

	@Override
	public long countPendingEmployees() {
		// TODO Auto-generated method stub
		return this.leavesRepo.countByStatus("Pending");
	}

	@Override
	public long countRejectedEmployees() {
		// TODO Auto-generated method stub
		return this.leavesRepo.countByStatus("Rejected");
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return leavesRepo.count();
	}

}
