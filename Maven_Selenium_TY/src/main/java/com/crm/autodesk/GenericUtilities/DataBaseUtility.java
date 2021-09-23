package com.crm.autodesk.GenericUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility {
	
	Connection con=null;
	Driver driverref;
	
	
	public void connectToDB() throws Throwable {
		
		DriverManager.registerDriver(driverref);
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Students\", \"root\", \"root");
	}
		
	public void  closeDB() throws Throwable {
		con.close();
	}
	
	public String getDataFromDB(String query, int ColoumnIndex) throws Throwable {
		String value=null;
		ResultSet resultSet =con.createStatement().executeQuery(query);
		while(resultSet.next()) {
			value=resultSet.getString(ColoumnIndex);
		}
		return value;
	}
	public void setDAtaIntoDB(String query) throws SQLException
	{
		int result=con.createStatement().executeUpdate(query);
		if(result==1)
		{
			System.out.println("data updated");
		}
		else
			System.out.println("data not updated");
	}
		
		
	}


