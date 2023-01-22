package com.hsptl.service;

import com.hsptl.bo.paitentBO;
import com.hsptl.dao.IPatientDAO;
import com.hsptl.dto.PaitentDTO;

public final class PaitentMgmtServiceImpl implements IPatientMgmtService {
	
	private IPatientDAO dao;
	
	
	

	public PaitentMgmtServiceImpl(IPatientDAO dao) {
		System.out.println("PaitentMgmtServiceImpl.PaitentMgmtServiceImpl---> 0 param constructor");
		this.dao = dao;
	}




	@Override
	public String PaitentRegister(PaitentDTO dto) throws Exception {

		System.out.println("PaitentMgmtServiceImpl.PaitentRegister()");
		
		double netamt = dto.getPDC() * dto.getDAYS();
		double GST = (netamt * 20)/100.0;
		double BILLAMT = netamt + GST;
		
		paitentBO ptBO = new paitentBO();
		 
		ptBO.setPNAME(dto.getPNAME());
		ptBO.setPADDRS(dto.getPADDRS());
		ptBO.setPDC(dto.getPDC());
		ptBO.setDAYS(dto.getDAYS());
		ptBO.setBILLAMT(BILLAMT);
		
		int count = dao.insert(ptBO);
		
		
		if(count == 0) {
			
			return "Patient registration failed";
		} else {
			return "paitent registration succesful --> Total Billl amount incl of GST is:: " + BILLAMT;
		}
		
	}

}
