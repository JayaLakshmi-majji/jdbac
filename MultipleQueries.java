package org.h2.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class MultipleQueries {
	public static void main(String args[])throws Exception{  
		Class.forName("org.h2.Driver");  
	    Connection con=DriverManager.getConnection("jdbc:h2:~/test","sa","jaya0000");  
	    try {
		con.setAutoCommit(false);  
		  
		Statement stmt=con.createStatement();  
		stmt.addBatch("insert into student values('leela',344,'kkd')");  
		stmt.addBatch("insert into student values('prasad',1324,'hyd')");  
		  
		stmt.executeBatch();//executing the batch  
		  
		con.commit(); 
		System.out.println("Successful");
	    }catch(Exception e) {
	    	con.rollback();
	    	e.printStackTrace();
	    }finally {
	    	con.close();
	    }

	}
}
