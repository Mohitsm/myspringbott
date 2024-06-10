package com.employeeMSMS.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeeMSMS.entity.Pro;
import com.employeeMSMS.entity.Prob;
import com.employeeMSMS.repositry.ProRepo;
import com.employeeMSMS.service.ProDervice;

@Service
public class ProServiceImpl implements ProDervice{
	
	@Autowired
	private ProRepo proRepo;

//	@Override
//	public Pro createPro(Pro pro) {
//		// TODO Auto-generated method stub
//		Pro pro2=this.proRepo.save(pro);
//		return pro2;
//	}

//	@Override
//	public Pro createPro(Pro pro, Prob prob) {
//		// TODO Auto-generated method stub
//		Pro pro2=this.createPro(pro, prob);
//		return pro2;
//	}

//	@Override
//	public Pro createPro(Pro pro) {
//		// TODO Auto-generated method stub
//		Pro pro2=this.proRepo.save(pro);
//		return pro2;
//	}
//
//	@Override
//	public List<Pro> getAllPro() {
//		// TODO Auto-generated method stub
//		
//		return this.proRepo.findAll();
//	}

	@Override
	public Pro creaePro(List<Pro> pros) {
		// TODO Auto-generated method stub
		
		return null;
	}
	
	

}
