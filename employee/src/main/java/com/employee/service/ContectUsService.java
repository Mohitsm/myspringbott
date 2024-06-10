package com.employee.service;

import java.util.List;

import com.employee.dto.ContectUsDto;




public interface ContectUsService {
	ContectUsDto createContectUs(ContectUsDto contectUsDto);
	ContectUsDto updateContectUs(ContectUsDto contectUsDto,Long contectUsId);
	void deleteContectUs(Long contectUsId);
	ContectUsDto getContectUsId(Long contectUsId);
	List<ContectUsDto> getAllContectUs();

}
