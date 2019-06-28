package org.h2.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class preapedStatement {
	public static void main(String[] args) throws Exception {  
		Class.forName("org.h2.Driver");  
	    Connection con=DriverManager.getConnection("jdbc:h2:~/test","sa","jaya0000");  
		try{  
		    con.setAutoCommit(false);
			PreparedStatement ps=con.prepareStatement("insert into student values(?,?,?)");  
			ps.setString(1,"devi");
			ps.setInt(2,6); 
			ps.setString(3,"hyd"); 
			int i=ps.executeUpdate();  
			Statement s = con.createStatement();
			String q = "update student set name = 'xxx' where id = 6";
			int c = s.executeUpdate(q);
			System.out.println( "update"  + c+" records affected");  
			System.out.println( "insert"  + i+" records affected");  
			 con.commit();     
		}catch (Exception e) {
		con.rollback();
			e.printStackTrace();}  
		
		}  
}
