package com.employee.service;

import java.util.List;


import com.employee.dto.DocumentDto;

public interface DocumentService {
	
	DocumentDto createDocument(DocumentDto documentDto);
	DocumentDto upadetDocument(DocumentDto documentDto,Long documentId);
	void deleteDocument(Long documentId);
	DocumentDto getDocumentId(Long documentId);
	List<DocumentDto> getAllDocument();

}
