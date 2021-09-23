package com.crm.Pratice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class MySql_NonSelect_2 {

	public static void main(String[] args) throws SQLException  {
		Connection con=null;
		try {
			Driver driverref= new Driver();
			DriverManager.registerDriver(driverref);
			
			
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Students", "root", "root");
			
			
			Statement stat = con.createStatement();
			String query = " insert into students_info (regno, firstname, middlename, lastname) values('12', 'ram','gowda', 'hassan') ";
			
			int result = stat.executeUpdate(query);
			 
			 if(result==1) {
				 System.out.println("user is created");
			 }
		} catch (Exception e) {
			System.err.println("user not created");
			
		}
		finally {
			con.close();
		}

	}

}
