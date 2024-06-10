package com.employeeMSMS.serviceImpl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeeMSMS.entity.Iamge;
import com.employeeMSMS.paylode.ImageDto;
import com.employeeMSMS.repositry.ImageRepo;
import com.employeeMSMS.service.ImageService;

@Service
public class ImageServiceImpl implements ImageService {
	
	@Autowired
	private ImageRepo imageRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public ImageDto create(ImageDto imageDto) {
		// TODO Auto-generated method stub
		Iamge iamge=this.modelMapper.map(imageDto, Iamge.class);
		Iamge iamge2=this.imageRepo.save(iamge);
		return this.modelMapper.map(iamge2, ImageDto.class);
	}

	@Override
	public ImageDto updateImage(ImageDto imageDto, Integer imageId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteImage(Integer imageId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ImageDto getImageById(Integer imageId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ImageDto> getAllImahe() {
		// TODO Auto-generated method stub
		return null;
	}

}
