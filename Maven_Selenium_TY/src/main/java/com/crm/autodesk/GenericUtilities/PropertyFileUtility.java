package com.crm.autodesk.GenericUtilities;

import java.io.FileInputStream;

import java.util.Properties;

public class PropertyFileUtility implements IPathConstants {
	
	
	public String getPropertyFileData(String key) throws Throwable {
	FileInputStream fis=new FileInputStream(propertyFilePath);
 
	Properties p = new Properties();
	p.load(fis);
	return p.getProperty(key);
}
}
