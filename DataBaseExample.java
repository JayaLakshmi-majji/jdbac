package org.h2.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DataBaseExample {
	public static void main(String args[]) {
		try {
			Class.forName("org.h2.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:h2:~/test","sa","jaya0000");  
			Statement stmt=con.createStatement();  
			ResultSet rs =stmt.executeQuery("select * from student");  
			
			while(rs.next())  
			System.out.println(rs.getString(1)+"  "+rs.getInt(2)+"  "+rs.getString(3));  
			con.close();  
		}catch(Exception e){
			System.out.println(e);
		}
	}
}
