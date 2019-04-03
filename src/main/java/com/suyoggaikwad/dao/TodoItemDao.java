package com.suyoggaikwad.dao;

import java.util.List;

import javax.sql.DataSource;

import com.suyoggaikwad.domain.TodoData;
import com.suyoggaikwad.domain.TodoItem;

public interface TodoItemDao {
	
	void createDataSource(DataSource ds);
	
	boolean insert(TodoItem todoItem);
	
	boolean delete(int id);
	
	boolean update(TodoItem todoItem);
	
	List<TodoItem> readAll();
	
	TodoItem read(int id);
	
}
