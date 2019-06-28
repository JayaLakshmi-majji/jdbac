package org.h2.util;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
public class ImageStoring {
	public static void main(String[] args) {  
		try{  
		Class.forName("org.h2.Driver");  
	    Connection con=DriverManager.getConnection("jdbc:h2:~/test","sa","jaya0000");  
		              
		PreparedStatement ps=con.prepareStatement("insert into imgtable values(?,?)");  
		ps.setString(1,"sonoo");  
		  
		FileInputStream fin=new FileInputStream("/home/jayalakshmi/HTML/index.jpeg");  
		ps.setBinaryStream(2,fin,fin.available());  
		int i=ps.executeUpdate();  
		System.out.println(i+" records affected");  
		          
		con.close();  
		}catch (Exception e) {e.printStackTrace();}  
		}  
}
