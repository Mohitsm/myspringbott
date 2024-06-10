package com.employee.serviceImpl;

import java.util.List;

import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.entity.Document;
import com.employee.exception.ResourceNotFoundException;
import com.employee.dto.DocumentDto;
import com.employee.repositiry.DocumentRepo;
import com.employee.service.DocumentService;
@Service
public class DocumentServiceImp implements DocumentService {
	
	@Autowired
	private DocumentRepo documentRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public DocumentDto createDocument(DocumentDto documentDto) {
		// TODO Auto-generated method stub
		Document document=this.modelMapper.map(documentDto, Document.class);
		Document createDocument=this.documentRepo.save(document);
		return this.modelMapper.map(createDocument, DocumentDto.class);
	}

	@Override
	public DocumentDto upadetDocument(DocumentDto documentDto, Long documentId) {
		// TODO Auto-generated method stub
		Document document=this.documentRepo.findById(documentId).orElseThrow(()-> new ResourceNotFoundException("Document","Id", documentId));
		document.setName(documentDto.getName());
		document.setUsername(documentDto.getUsername());
		document.setEmail(documentDto.getEmail());
		Document updateDocument=this.documentRepo.save(document);
		
		return this.modelMapper.map(updateDocument, DocumentDto.class);
	}

	@Override
	public void deleteDocument(Long documentId) {
		// TODO Auto-generated method stub
		Document document=this.documentRepo.findById(documentId).orElseThrow(()-> new ResourceNotFoundException("Document","Id", documentId));

		this.documentRepo.delete(document);
		
	}

	@Override
	public DocumentDto getDocumentId(Long documentId) {
		// TODO Auto-generated method stub
		Document document=this.documentRepo.findById(documentId).orElseThrow(()-> new ResourceNotFoundException("Document","Id", documentId));

		
		return this.modelMapper.map(document, DocumentDto.class);
	}

	@Override
	public List<DocumentDto> getAllDocument() {
		// TODO Auto-generated method stub
		List<Document> documents=this.documentRepo.findAll();
		List<DocumentDto> documentDtos=documents.stream().map((doco)->this.modelMapper.map(doco, DocumentDto.class)).collect(Collectors.toList());
		return documentDtos;
	}

}
