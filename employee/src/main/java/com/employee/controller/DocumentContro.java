package com.employee.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.dto.ApiResponse;
import com.employee.dto.DocumentDto;
import com.employee.service.DocumentService;

//@CrossOrigin("*")
@RestController
@RequestMapping("/api/document")
public class DocumentContro {
	
	@Autowired
	private DocumentService documentService;
	
	//create

	@PostMapping("/")
	public ResponseEntity<DocumentDto> createDocument(@RequestBody DocumentDto documentDto){
		DocumentDto createDocument=this.documentService.createDocument(documentDto);
		return new ResponseEntity<DocumentDto>(createDocument,HttpStatus.CREATED);
	}
	//update
	@PutMapping("/{documentId}")
	public ResponseEntity<DocumentDto> updateDocument(@RequestBody DocumentDto documentDto,@PathVariable Long documentId){
		DocumentDto updateDocument=this.documentService.upadetDocument(documentDto, documentId);
		return ResponseEntity.ok(updateDocument);
	}
	//delete
	@DeleteMapping("/{documentId}")
	public ResponseEntity<ApiResponse> deleteDocument(@PathVariable Long documentId){
		this.documentService.deleteDocument(documentId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User Dalete Successfully",true),HttpStatus.OK);

		
	}
	//getDocumentId
	@GetMapping("/{documentId}")
	public ResponseEntity<DocumentDto> getDocumentId(@PathVariable Long documentId){
		return ResponseEntity.ok(this.documentService.getDocumentId(documentId));
	}
	//getAllDocument
	@GetMapping("/")
	public ResponseEntity<List<DocumentDto>> getAllDocument(){
		return ResponseEntity.ok(this.documentService.getAllDocument());
	}
}
