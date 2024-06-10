package com.employeeMSMS.service;

import java.util.List;

import com.employeeMSMS.paylode.LeavesDto;

public interface LeavesService {
	LeavesDto createLeaves(LeavesDto leavesDto);
	LeavesDto updateLeaves(LeavesDto leavesDto,Integer leavesId);
	void deleteLeaves(Integer leavesId);
	LeavesDto getLeavesById(Integer leavesId);
	List<LeavesDto> getAllLeaves();
	public long countApprovedEmployees();
	public long countPendingEmployees();
	public long countRejectedEmployees();
	public Long count();

}
