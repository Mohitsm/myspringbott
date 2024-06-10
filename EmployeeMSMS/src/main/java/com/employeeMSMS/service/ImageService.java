package com.employeeMSMS.service;

import java.util.List;

import com.employeeMSMS.paylode.ImageDto;

public interface ImageService {
	
	ImageDto create(ImageDto imageDto);
	ImageDto updateImage(ImageDto imageDto,Integer imageId);
	void deleteImage(Integer imageId);
	ImageDto getImageById(Integer imageId);
	List<ImageDto> getAllImahe();

}
