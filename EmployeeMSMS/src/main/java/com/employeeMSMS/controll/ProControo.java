//package com.employeeMSMS.controll;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.employeeMSMS.entity.Pro;
//import com.employeeMSMS.entity.Prob;
//import com.employeeMSMS.service.ProDervice;
//
//@RestController
//@RequestMapping("api/pro")
//public class ProControo {
//	
//	@Autowired
//	private ProDervice proDervice;
//	
//	//crate
//	@PostMapping("/")
//	public ResponseEntity<Pro> createPro(@RequestBody Pro pro){
//		Pro pro2=this.proDervice.createPro(pro);
//		return new ResponseEntity<Pro>(pro2,HttpStatus.CREATED);
//	}
//	
//	@GetMapping("/")
//	public ResponseEntity<List<Pro>> getAllPro(){
//		return ResponseEntity.ok(this.proDervice.getAllPro());
//	}
//
//}
