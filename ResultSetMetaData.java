package org.h2.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetMetaData {
	public static void main(String args[]) throws SQLException {
		Connection con = null;
		ResultSet rs = null;
		try {
			Class.forName("org.h2.Driver");
			con = DriverManager.getConnection("jdbc:h2:~/test","sa","jaya0000");
			Statement s = con.createStatement();
			rs = s.executeQuery("select * from DEMO_USR");
			java.sql.ResultSetMetaData rsmd = rs.getMetaData();
			System.out.println("metadata " + rsmd);
			System.out.println("col count :"+rsmd.getColumnCount());
			System.out.println("col count :" +rsmd.getColumnName(1));
			System.out.println(rsmd.getColumnDisplaySize(1));
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}finally {
			con.close();
			rs.close();
		}
	}
}
