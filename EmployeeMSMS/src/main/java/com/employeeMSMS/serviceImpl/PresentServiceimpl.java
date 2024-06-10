package com.employeeMSMS.serviceImpl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeeMSMS.paylode.PresentDto;
import com.employeeMSMS.repositry.PresentREpo;
import com.employeeMSMS.service.PresentService;
@Service
public class PresentServiceimpl implements PresentService {
	
	@Autowired
	private PresentREpo presentREpo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public PresentDto createPresent(PresentDto presentDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PresentDto updatePresent(PresentDto presentDto, Integer presentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePresent(Integer presentId) {
		// TODO Auto-generated method stub

	}

	@Override
	public PresentDto getPresentById(Integer presentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PresentDto> getAllPresent() {
		// TODO Auto-generated method stub
		return null;
	}

}
