package com.dxc.JdbcService;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.dxc.beans.Mark;
import com.dxc.jdbcDAO.MarkJdbcDAO;

public class MarkService implements MarkServiceI<Mark> {

	@Override
	public boolean save(Mark e) {
		boolean res=false;
		try {
			MarkJdbcDAO markJdbcDAO = new MarkJdbcDAO();
			return markJdbcDAO.save(e);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return res;
	}

	@Override
	public boolean edit(Mark e){
		boolean res=false;
		try {
			MarkJdbcDAO markJdbcDAO = new MarkJdbcDAO();
			res=markJdbcDAO.edit(e);
			if(res)
			{
				markJdbcDAO.save();
			}

		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	return res;
	}

	@Override
	public boolean delete(String examid, int studentid) {
		boolean res = false;
			try {
				MarkJdbcDAO markJdbcDAO = new MarkJdbcDAO();
				res = markJdbcDAO.delete(examid, studentid);
				if(res)
				{
					markJdbcDAO.save();
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		return res;
		
	}

	@Override
	public List<Mark> find(String examid) {
		List<Mark> marks=null;
		
		try {
			MarkJdbcDAO markJdbcDAO=new MarkJdbcDAO();
			marks=markJdbcDAO.find(examid);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return marks;
	}

	@Override
	public List<Mark> findAll(){
	List<Mark> marks=null;
		
		try {
			MarkJdbcDAO markJdbcDAO=new MarkJdbcDAO();
			marks=markJdbcDAO.findAll();
			} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return marks;

	}

}
