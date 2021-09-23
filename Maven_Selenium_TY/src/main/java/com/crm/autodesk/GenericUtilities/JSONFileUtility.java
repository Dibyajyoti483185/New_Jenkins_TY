package com.crm.autodesk.GenericUtilities;


import java.io.FileReader;
import java.util.HashMap;

import org.json.simple.parser.JSONParser;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;


/*this class contains methods to read data from json fle;
 * 
 * author: Dibyajyoti Satyapriya Sahoo
 * 
 */

public class JSONFileUtility {
	
	public String readDataFromJSON(String key) throws Throwable {
		FileReader file = new FileReader(IPathConstants.jsonFilePath);
		JSONParser jsonobj=new JSONParser();
		Object jobj= jsonobj.parse(file);
		 
		 HashMap map=(HashMap)jobj;
		 String keyValue = map.get(key).toString();
		 
		 return keyValue;
		
		
	}

}
