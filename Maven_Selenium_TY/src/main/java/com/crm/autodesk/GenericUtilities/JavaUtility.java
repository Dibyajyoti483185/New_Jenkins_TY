package com.crm.autodesk.GenericUtilities;


import java.time.LocalDateTime;
import java.util.Date;
import java.util.Random;

/*This class contains generic method pertaining to JAVA
 * 
 * Author: Dibyajyoti Satyapriya Sahoo
 */

public class JavaUtility {
	
	/*
	 * This method generates random number
	 */
   public int getRandomNum() {
	   
	   Random ran=new Random();
	   int randomNum= ran.nextInt(1000);
	   return randomNum;
   }
   
   public String getDateAndTime() {
	  LocalDateTime d = LocalDateTime.now();
		String dateTime = d.toString().replaceAll(":", "-");
		return dateTime;
   }
}
