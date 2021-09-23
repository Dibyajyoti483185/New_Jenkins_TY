package com.crm.Pratice;

import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class ReadDataFromXML {
	@Test
	public void readDataFromXML(XmlTest xmlObj) {
		System.out.println(xmlObj.getParameter("browser"));
		
	}

}


