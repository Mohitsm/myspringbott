package com.employee.service;

import java.util.List;

import com.employee.dto.ReportDto;

public interface ReportService {
	
	ReportDto createReport(ReportDto reportDto);
	ReportDto updateReport(ReportDto reportDto,Long reportId);
	void deleteReport(Long reportId);
	ReportDto getReportId(Long reportId);
	List<ReportDto> getAllReport();

}
