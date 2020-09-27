package com.dxc.JdbcService;

import java.util.List;

public interface MarkServiceI<E> {
	boolean save(E e);
	boolean edit(E e);
	boolean delete(String examid,int studentid);
	List<E> find(String examid);
	List<E> findAll();
}