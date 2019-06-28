package org.h2.util;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBaseMetData {
	public static void main(String args[]) throws SQLException {
		Connection con = null;
		try {
			Class.forName("org.h2.Driver");
			con = DriverManager.getConnection("jdbc:h2:~/test","sa","jaya0000");
			DatabaseMetaData dbmd = con.getMetaData(); 
			String table[]={"TABLE"}; 
			ResultSet rs = dbmd.getTables(null, null, null,table);
			while(rs.next()){  
				System.out.println(rs.getString(3));  
				}  
			System.out.println("Driver Name: "+dbmd.getDriverName());  
			System.out.println("Driver Version: "+dbmd.getDriverVersion());  
			System.out.println("UserName: "+dbmd.getUserName());  
			System.out.println("Database Product Name: "+dbmd.getDatabaseProductName());  
			System.out.println("Database Product Version: "+dbmd.getDatabaseProductVersion());  
			
		}catch(Exception e) {
			
		}finally {
			con.close();
		}
	}
}
