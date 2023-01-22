package com.hsptl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.hsptl.bo.paitentBO;

public class PaitentDAOImpl implements IPatientDAO {

	private DataSource ds;
	
	private static final String PAITENT_INSERT_QUERY = "INSERT INTO CORONAPATIENT_ASSIGMENT1_PROJECT values (CORONA_SEQ.NEXTVAL,?,?,?,?,?) ";

	
	public PaitentDAOImpl(DataSource ds) {
		System.out.println("PaitentDAOImpl.PaitentDAOImpl ---> 0 param constructor");
		this.ds = ds;
	}



	@Override
	public int insert(paitentBO bo) throws Exception{
		System.out.println("PaitentDAOImpl.insert()");
		int count = 0;
		try(Connection con = ds.getConnection();
				PreparedStatement ps = con.prepareStatement(PAITENT_INSERT_QUERY);){
			
			
			if(ps!=null) {
				
				ps.setString(1, bo.getPNAME());
				ps.setString(2, bo.getPADDRS());
				ps.setDouble(3, bo.getPDC());
				ps.setInt(4, bo.getDAYS());
				ps.setDouble(5, bo.getBILLAMT());
				
				count = ps.executeUpdate();
			}
			
			
			
		
	} catch (SQLException se) {
		
		se.printStackTrace();
		
		throw se;
		
	}catch (Exception e) {
		 
		e.printStackTrace();
		
		throw e;
	}
		
		return count;
	}

}
