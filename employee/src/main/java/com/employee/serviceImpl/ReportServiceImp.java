package com.employee.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.entity.Report;
import com.employee.exception.ResourceNotFoundException;
import com.employee.dto.ReportDto;
import com.employee.repositiry.ReportRepo;
import com.employee.service.ReportService;
@Service
public class ReportServiceImp implements ReportService {
	
	
	@Autowired
	private ReportRepo reportRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public ReportDto createReport(ReportDto reportDto) {
		// TODO Auto-generated method stub
		Report report=this.modelMapper.map(reportDto, Report.class);
		Report createReport=this.reportRepo.save(report);
		return this.modelMapper.map(createReport, ReportDto.class);
	}

	@Override
	public ReportDto updateReport(ReportDto reportDto, Long reportId) {
		// TODO Auto-generated method stub
		Report report=this.reportRepo.findById(reportId).orElseThrow(()-> new ResourceNotFoundException("Report", "Id", reportId));
		report.setName(reportDto.getName());
		report.setUsername(reportDto.getUsername());
		report.setEmail(reportDto.getEmail());
		Report updateReport=this.reportRepo.save(report);
		return this.modelMapper.map(updateReport, ReportDto.class);
	}

	@Override
	public void deleteReport(Long reportId) {
		// TODO Auto-generated method stub
		Report report=this.reportRepo.findById(reportId).orElseThrow(()-> new ResourceNotFoundException("Report", "Id", reportId));

		this.reportRepo.delete(report);
		
	}

	@Override
	public ReportDto getReportId(Long reportId) {
		// TODO Auto-generated method stub
		Report report=this.reportRepo.findById(reportId).orElseThrow(()-> new ResourceNotFoundException("Report", "Id", reportId));

		return this.modelMapper.map(report, ReportDto.class);
	}

	@Override
	public List<ReportDto> getAllReport() {
		// TODO Auto-generated method stub
		List<Report> reports=this.reportRepo.findAll();
		List<ReportDto> reportDtos=reports.stream().map((re)->this.modelMapper.map(re, ReportDto.class)).collect(Collectors.toList());
		return reportDtos;
	}

}
