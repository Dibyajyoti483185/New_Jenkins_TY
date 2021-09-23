package com.crm.Pratice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ReadDataFrom_MySql_DB {

	public static void main(String[] args) throws Throwable   {
		Driver driverref= new Driver();
		DriverManager.registerDriver(driverref);
		
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Students", "root", "root");
		
		
		Statement stat = con.createStatement();
		String query = " select * from students_info ";
		
		
		ResultSet result = stat.executeQuery(query);
		
		
		while(result.next()) {
			System.out.println(result.getString(1) + "\t" + result.getString(2) + "\t" +result.getString(3) + "\t" + result.getString(4) );
		}
		
		con.close();
		
		

	}

}
