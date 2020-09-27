package com.dxc.jdbcDAO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.dxc.beans.Mark;

public class MarkJdbcDAO extends jdbcDAO implements MarkDAO<Mark> {
	
	PreparedStatement p=null;
	ResultSet rs=null;
	
	public MarkJdbcDAO() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		super();
	
	}

	@Override
	public boolean save(Mark e) throws SQLException, ParseException, FileNotFoundException, ClassNotFoundException, IOException {
		boolean res=false;
		
		p=con.prepareStatement("insert into mark values(?,?,?,?,?,?,?)");
		p.setString(1, e.getExamid());
		p.setInt(2,e.getStudentid());
		p.setString(3,e.getName());
		p.setString(4,e.getExam_name());
		p.setInt(5,e.getSub1());
		p.setInt(6,e.getSub2());
		p.setInt(7,e.getSub3());
		if(1==p.executeUpdate())
		{
			res=true;
		}
		con.commit();
		con.close();
		return res;
	}

	@Override
	public boolean edit(Mark e) throws SQLException, ParseException, FileNotFoundException, ClassNotFoundException, IOException {
		boolean res=false;
		p=con.prepareStatement("update mark set name=?,exam_name=?,sub1=?,sub2=?,sub3=? where examid=? and studentid=?");
		p.setString(1,e.getName());
		p.setString(2,e.getExam_name());
		p.setInt(3,e.getSub1());
		p.setInt(4,e.getSub2());
		p.setInt(5,e.getSub3());
		p.setString(6, e.getExamid());
		p.setInt(7, e.getStudentid());
		if(1==p.executeUpdate())
		{
			res=true;
		}
		con.commit();
		con.close();
		return res;
	}


	@Override
	public boolean delete(String examid, int studentid) throws SQLException, ParseException, FileNotFoundException, ClassNotFoundException, IOException {
		boolean res=false;
		p=con.prepareStatement("delete from mark where examid=? and studentid=?");
		p.setString(1, examid);
		p.setInt(2, studentid);
		if(1==p.executeUpdate())
		{
			res=true;
		}
		con.commit();
		con.close();
		return res;
	}

	@Override
	public List<Mark> find(String examid) throws SQLException, ParseException, FileNotFoundException, ClassNotFoundException, IOException {
		List<Mark> marks=new ArrayList<>();
		Mark mark=null;
		p=con.prepareStatement("select * from mark where examid=?");
		p.setString(1, examid);
		rs=p.executeQuery();
		while(rs.next())
		{
			String examid1=rs.getString("examid");
			int studentid=rs.getInt(2);
			String name=rs.getString(3);
			String exam_name=rs.getString(4);
			int sub1=rs.getInt(5);
			int sub2=rs.getInt(6);
			int sub3=rs.getInt(7);
			mark=new Mark(examid1, studentid, name, exam_name, sub1, sub2, sub3);
			marks.add(mark);
		}
		return marks;

	}


	@Override
	public List<Mark> findAll() throws Exception {
		List<Mark> marks=new ArrayList<>();
		Mark mark=null;
		Statement s= con.createStatement();
		rs=s.executeQuery("select * from mark");
		while(rs.next())
		{
			String examid=rs.getString("examid");
			int studentid=rs.getInt(2);
			String name=rs.getString(3);
			String exam_name=rs.getString(4);
			int sub1=rs.getInt(5);
			int sub2=rs.getInt(6);
			int sub3=rs.getInt(7);
			mark=new Mark(examid, studentid, name, exam_name, sub1, sub2, sub3);
			marks.add(mark);
		}
		return marks;
		}

}
