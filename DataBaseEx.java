package org.h2.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DataBaseEx {
	public static void main(String args[]) throws SQLException {
		
	Connection con = null;
	Scanner sc = null;
	try {
		 sc= new Scanner(System.in);
		 System.out.println("enter the detais you want to store");
		 System.out.println("enter the gender");
		String gender = sc.nextLine();
		System.out.println("enter the name");
		String name = sc.nextLine();
		Class.forName("org.h2.Driver");
	     con = DriverManager.getConnection("jdbc:h2:~/test","sa","jaya0000");
	     con.setAutoCommit(false);
	     
		
		 Statement s = con.createStatement();
		 s.executeUpdate("INSERT INTO DEMO_USR(gender,name) values('"+gender+"','"+name+"')");
		
		 con.commit();
	} catch (Exception e) {
		con.rollback();
		e.printStackTrace();
	}finally {
		try {
			con.close();
			sc.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	}
}
