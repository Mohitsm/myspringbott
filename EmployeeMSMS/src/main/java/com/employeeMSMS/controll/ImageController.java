package com.employeeMSMS.controll;

import com.employeeMSMS.entity.Iamge;
import com.employeeMSMS.paylode.FileResponse;
import com.employeeMSMS.paylode.ImageDto;
import com.employeeMSMS.service.FileService;
import com.employeeMSMS.service.ImageService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/image")
@RestController
public class ImageController {
	
	@Autowired
	private ImageService imageService;
	
	@Autowired
	private FileService fileService;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Value("${project.image}")
	private String path;
	
	private Logger logger=LoggerFactory.getLogger(ImageController.class);
	
	
	@PostMapping("/")
	public ResponseEntity<?> addImage(@RequestParam("userData") String image,@RequestParam("file") MultipartFile file  ) throws JsonMappingException, JsonProcessingException{
		logger.info("file name {}",file.getOriginalFilename());
		logger.info("image:{}",image);
		
		Iamge iamge=objectMapper.readValue(image,Iamge.class);
		ImageDto imageDto=this.objectMapper.readValue(image, ImageDto.class);
		
		ImageDto imageDto2=this.imageService.create(imageDto);
		
		String fileName;
		try {
			fileName = this.fileService.uplodeImage(path, file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<FileResponse>(new FileResponse(null,"Image is successfully not uplodeed !!"), HttpStatus.OK);

		}
		
		
		
		return new ResponseEntity<FileResponse>(new FileResponse(fileName,"Image is successfully uplodeed !!"), HttpStatus.OK);
	}
//	@PostMapping("/")
//	public ResponseEntity<?> fileUplode(@RequestParam("file") MultipartFile[] file){
//		
//		
//		logger.info("{} file uplode",file.length);
//		
//		Arrays.stream(file).forEach(mu->{
//			logger.info("file name {}",mu.getOriginalFilename());
//		});
//		
//		return ResponseEntity.ok("done");
//	}

}
