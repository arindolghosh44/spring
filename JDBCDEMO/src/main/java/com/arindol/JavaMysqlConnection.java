package com.arindol;
import java.sql.*;
//static loading of class
class TestConnection{
	private  Connection cn=null;
	private Statement st=null;
	
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	
	private String select_sql="select * from customer";
	private String insert_sql="insert into customer values(?,?,?)";//PreparedStatement
	private String delete_sql="delete from customer where cid=?";
	private String update_sql="update  customer set cname=?,cphno=? where cid=?";
	ConnectionFactory ry=new ConnectionFactory();
	public void getData() throws SQLException
	{
		st=ry.getConn().createStatement();//create the statement
		
		rs=st.executeQuery(select_sql);//execute the query and store data into resultSet
		
		while(rs.next())
		{
			System.out.println(rs.getString(1)+" "+ rs.getString(2)+" "+rs.getString(3));
			
		}
		
	}
	
	public void adddata() throws SQLException
	{
		ps=ry.getConn().prepareStatement(insert_sql);
		 ps.setString(1,"c4");
		 ps.setString(2,"binoy");
		 ps.setString(3,"delhi");
		 ps.executeUpdate();
		
			
	}
	
	public void deleteData() throws ClassNotFoundException, SQLException 
	{
		
	     ps=ry.getConn().prepareStatement(delete_sql);
	     ps.setString(1,"c3");
	     ps.executeUpdate();
	     
	     
	     
	     
	}
	public void UpdateData() throws ClassNotFoundException, SQLException 
	{
		
	     ps=ry.getConn().prepareStatement(update_sql);
	     ps.setString(1,"saasa");
	     ps.setString(2,"1");
	     ps.setString(3,"c4");
	     ps.executeUpdate();
	     
	     
	     
	     
	}
	
}





public class JavaMysqlConnection {

	public static void main(String [] args) throws SQLException, ClassNotFoundException
	{
		TestConnection te=new TestConnection();
		
		System.out.println("+++++++++++++++");
		te.getData();
		te.adddata();
		te.getData();
		System.out.println("++++++++++++++++++++++++++++");
		
		te.getData();
		te.deleteData();
		te.getData();
		System.out.println("++++++++++++++++++++++++++++");
		
		
		te.getData();
		te.UpdateData();
		te.getData();
		
	}
	
	
}
