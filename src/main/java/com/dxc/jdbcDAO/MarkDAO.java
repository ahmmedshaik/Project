package com.dxc.jdbcDAO;

import java.util.List;

import com.dxc.beans.Mark;

public interface MarkDAO<E> {
	boolean save(E e) throws Exception;
	boolean edit(E e) throws Exception;
	boolean delete(String examid,int studentid) throws Exception;
	List<E> find(String examid) throws Exception;
	List<E> findAll() throws Exception;	
}
