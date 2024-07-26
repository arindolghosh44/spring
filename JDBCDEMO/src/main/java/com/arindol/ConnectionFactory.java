package com.arindol;
import java.sql.*;
public class ConnectionFactory {

	private  Connection cn=null;
	
	public Connection getConn() throws SQLException
	{
		
		try {
			//dynamic class loading
			Class.forName("com.mysql.cj.jdbc.Driver");//Register and load the driver
			
			//Establishment the connection
			cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ FullStackDB","root","password");
			
			
			
			}
			catch(ClassNotFoundException e)
			{
				e.printStackTrace();
			}
		return cn;
	}
	
	
	
	
	
	
	
	
}
