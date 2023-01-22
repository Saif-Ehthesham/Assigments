package com.hsptl.controller;

import com.hsptl.dto.PaitentDTO;
import com.hsptl.service.IPatientMgmtService;
import com.hsptl.vo.PaitentVO;

public class MainController {
	
	private IPatientMgmtService service;

	public MainController(IPatientMgmtService service) {
		System.out.println("MainController.MainController --> 0 param constructor");
		this.service = service;
	}
	
	public String processPaitent(PaitentVO vo) throws Exception{
		
		PaitentDTO Pdto = new PaitentDTO();
		
		Pdto.setPNAME(vo.getPname());
		Pdto.setPADDRS(vo.getPaddrs());
		Pdto.setPDC(Double.parseDouble(vo.getPDC()));
		Pdto.setDAYS(Integer.parseInt(vo.getDAYS()));
		
		String ResultMSG = service.PaitentRegister(Pdto);
		
		return ResultMSG;
		
	}
	
	

}
