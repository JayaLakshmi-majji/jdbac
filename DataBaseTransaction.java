package org.h2.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class DataBaseTransaction {
	public static void main(String args[] ) throws SQLException {
		
		Connection con = null;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			String gender1 = br.readLine();
			String name1 = br.readLine();
			Class.forName("org.h2.Driver");
		     con = DriverManager.getConnection("jdbc:h2:~/test","sa","jaya0000");
		     con.setAutoCommit(false);
			 String query =  "insert into DEMO_USR(id,gender, name) values(?,?,?)";
			 PreparedStatement s = con.prepareStatement(query);
			 s.setLong(1, 10);
			 s.setString(2,gender1);
			 s.setString(3,name1);
			 s.executeUpdate();
			 con.commit();
			 System.out.println("Successs");
		} catch (Exception e) { 
			con.rollback();
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}			 

}
