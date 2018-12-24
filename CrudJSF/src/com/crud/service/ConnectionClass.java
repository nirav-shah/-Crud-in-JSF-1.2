package com.crud.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.crud.jsf.StudentBean;



public class ConnectionClass {
	public String user ;
	public String pass ;
	public Statement st;
	public PreparedStatement pst;
	public Connection con = null;
	public ResultSet rs ;


public Connection connect()
{
	
	String url = "jdbc:mysql://localhost:3306/db1";
	user = "root";
	pass = "root";
	try {
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(url,user,pass);
	} catch (SQLException  e) {
		System.out.println(e);
	}
		catch (ClassNotFoundException e) {
			System.out.println(e);
		}
	
	return con;
	
}

public List<StudentBean> getUserList()
{
	List<StudentBean> list = new ArrayList<StudentBean>();
	try {
		con = this.connect();
		st = con.createStatement();
		rs = st.executeQuery("select * from student");
		while(rs.next())
		{
			StudentBean s = new StudentBean();
			s.setId(rs.getInt("id"));
			s.setRoll(rs.getString("roll"));
			s.setName(rs.getString("name"));
			s.setEmail(rs.getString("email"));
			s.setPhone(rs.getString("phone"));
			s.setUsername(rs.getString("username"));
			s.setPassword(rs.getString("password"));
			list.add(s);
		}
		con.close();
	} catch (Exception sqlException) {
		sqlException.printStackTrace();
	}
	return list;
}	

public boolean validate(String user,String password) 
{
	try {
		con = this.connect();
		pst = con.prepareStatement("select * from student where username=? and password=?");
		pst.setString(1, user);
		pst.setString(2, password);
		rs = pst.executeQuery();
		if(rs.next())
		{
			return true;
		}
		con.close();
	} catch (SQLException e) {
		e.printStackTrace();
		return false;
	}
	return false;
}

public boolean add(StudentBean s)
{	int rs=0;
	try {
		con = this.connect();
		pst = con.prepareStatement("insert into student(roll,name,email,phone,username,password) values(?,?,?,?,?,?)");
		pst.setString(1, s.getRoll());
		pst.setString(2, s.getName());
		pst.setString(3, s.getEmail());
		pst.setString(4, s.getPhone());
		pst.setString(5, s.getUsername());
		pst.setString(6, s.getPassword());
		rs = pst.executeUpdate();
		if(rs!=0)
		{
			return true;
		}
		else
		{
			return false;
		}
	} catch (SQLException e) {
		e.printStackTrace();
		return false;
	}
	
}

public StudentBean editDB(int id)
{	StudentBean sb =null;
	try {
		con = this.connect();
		pst = con.prepareStatement("select * from student where id=?");
		pst.setInt(1, id);
		rs = pst.executeQuery();
		while(rs.next())
		{
			sb = new StudentBean();
			sb.setId(rs.getInt("id"));
			sb.setRoll(rs.getString("roll"));
			sb.setName(rs.getString("name"));
			sb.setEmail(rs.getString("email"));
			sb.setPhone(rs.getString("phone"));
			sb.setUsername(rs.getString("username"));
			sb.setPassword(rs.getString("password"));
			
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	}	
	
	return sb;
}

public boolean update(StudentBean s)
{	int rs=0;
	try {
		con = this.connect();
		pst = con.prepareStatement("update student set roll=?,name=?,email=?,phone=?,username=?,password=? where id=?");
		pst.setString(1, s.getRoll());
		pst.setString(2, s.getName());
		pst.setString(3, s.getEmail());
		pst.setString(4, s.getPhone());
		pst.setString(5, s.getUsername());
		pst.setString(6, s.getPassword());
		pst.setInt(7, s.getId());
		System.out.println(pst);
		rs = pst.executeUpdate();
		if(rs!=0)
		{
			return true;
		}
		else
		{
			return false;
		}
	} catch (SQLException e) {
		e.printStackTrace();
		return false;
	}
	
}


public boolean delete(int id)
{	int rs=0;

	try {
		con = this.connect();
		pst = con.prepareStatement("delete from student where id=?");
		pst.setInt(1, id);
		rs = pst.executeUpdate();
		if(rs!=0)
		{
			return true;
		}
		con.close();
	} catch (SQLException e) {
		e.printStackTrace();
		return false;
	}
	return false;
	
}



}