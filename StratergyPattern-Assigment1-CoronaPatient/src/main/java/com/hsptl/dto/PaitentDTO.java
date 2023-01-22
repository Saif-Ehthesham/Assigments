package com.hsptl.dto;

import java.io.Serializable;

public class PaitentDTO implements Serializable{

	private Integer PID;
	private String PNAME;
	private String PADDRS;
	private Double PDC;
	private Integer DAYS;
	
	
	
	
	public Integer getPID() {
		return PID;
	}
	public void setPID(Integer pID) {
		PID = pID;
	}
	public String getPNAME() {
		return PNAME;
	}
	public void setPNAME(String pNAME) {
		PNAME = pNAME;
	}
	public String getPADDRS() {
		return PADDRS;
	}
	public void setPADDRS(String pADDRS) {
		PADDRS = pADDRS;
	}
	public Double getPDC() {
		return PDC;
	}
	public void setPDC(Double pDC) {
		PDC = pDC;
	}
	public Integer getDAYS() {
		return DAYS;
	}
	public void setDAYS(Integer dAYS) {
		DAYS = dAYS;
	}
	
	
	
}
