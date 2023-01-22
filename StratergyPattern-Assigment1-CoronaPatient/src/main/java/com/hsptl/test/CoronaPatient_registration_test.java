package com.hsptl.test;

import java.util.Scanner;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.hsptl.vo.PaitentVO;
import com.hsptl.controller.MainController;

public class CoronaPatient_registration_test {

	public static void main(String[] args) {
		
		System.out.println(" Welcome to CORONA paitent hospital registrantion ");
		System.out.println(" Please enter below details ");
		Scanner sc = new Scanner(System.in);
		
String name=null,addrs=null,pdc=null,days=null;
		
		if(sc!=null) {
			
			System.out.println("Enter paitent name : ");
			name=sc.next();
			System.out.println("Enter Paitent address : ");
			addrs=sc.next();
			System.out.println("Enter per day charge amount : ");
			pdc=sc.next();
			System.out.println("Enter days of hospitilization : ");
			days=sc.next();
		
	}
		
		PaitentVO vo = new PaitentVO();
		
		vo.setPname(name);
		vo.setPaddrs(addrs);
		vo.setPDC(pdc);
		vo.setDAYS(days);
 
		
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/hsptl/cfgs/ApplicationContext.xml");
		
		
MainController controller =  factory.getBean("controller",MainController.class);
		
		try {
			String resultMsg =  controller.processPaitent(vo);
			System.out.println(resultMsg);
		} catch (Exception e) {
			System.err.println("problem in paitent registration  :: "+ e.getMessage());
			e.printStackTrace();
		}
}

}
