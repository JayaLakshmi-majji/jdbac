/**
 * 
 */
package org.h2.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * The Class DatabaseValuesFromUser.
 */
public class DatabaseValuesFromUser {

/**
 * The main method.
 *
 * @param args the arguments
 * @throws SQLException 
 */
public static void main(String args[] ) throws SQLException {
		
		Connection con = null;
		Scanner scanner = null;
		try {
			scanner= new Scanner(System.in);
			String gender = scanner.nextLine();
			String name = scanner.nextLine();
			Class.forName("org.h2.Driver");
		    con = DriverManager.getConnection("jdbc:h2:~/test","sa","jaya0000");
		    con.setAutoCommit(false);
		     
			//To insert data into the database
		     
			 String qry =  "insert into  DEMO_USR(gender,name) values('"+gender+ "','"+name+ "')";
			 PreparedStatement ps = con.prepareStatement(qry);
			 int c = ps.executeUpdate();
			 System.out.println(c+ "row(s) inserted");
			 
			 //To retrieve data from data base
			 
			 String query =  "select * from DEMO_USR";
			 PreparedStatement s = con.prepareStatement(query);
			 ResultSet rs = s.executeQuery();
			 while(rs.next())  
				 System.out.println(rs.getLong(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
			 con.commit();
		} catch (Exception e) { 
			con.rollback();
			e.printStackTrace();
		}finally {
			try {
				con.close();
				scanner.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
}
