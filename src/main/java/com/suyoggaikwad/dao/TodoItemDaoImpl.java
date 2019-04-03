package com.suyoggaikwad.dao;


import java.sql.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.suyoggaikwad.domain.TodoItem;

@Repository
public class TodoItemDaoImpl implements TodoItemDao{

	JdbcTemplate jdbcTemplate;
	
	@Autowired
	@Override
	public void createDataSource(DataSource ds) {
		jdbcTemplate = new JdbcTemplate(ds);
	}

	@Override
	public boolean insert(TodoItem todoItem) {
		String sqlQuery = "INSERT INTO todoitems (title, details, date) VALUES " +
							"(?, ?, ?)";
		
		Object[] args = new Object[] {todoItem.getTitle(), todoItem.getDetails(), Date.valueOf(todoItem.getDate())};
		return jdbcTemplate.update(sqlQuery, args) == 1;
		
	}

	@Override
	public boolean delete(int id) {
		String sqlQuery = "DELETE FROM todoitems WHERE id = ?";
		Object[] args = new Object[] {id};
		return jdbcTemplate.update(sqlQuery, args) == 1;
	}

	@Override
	public boolean update(TodoItem todoItem) {
		String sqlQuery = "UPDATE todoitems SET title = ?, details = ?, date = ? WHERE id = ?";
		Object[] args = new Object[] {todoItem.getTitle(), todoItem.getDetails(), Date.valueOf(todoItem.getDate()), todoItem.getId()};
		return jdbcTemplate.update(sqlQuery, args) == 1;
	}

	@Override
	public List<TodoItem> readAll() {
		String sqlQuery = "SELECT * FROM todoitems";
		List<TodoItem> list = jdbcTemplate.query(sqlQuery, new TodoItemRowMapper());
		return list;
	}

	@Override
	public TodoItem read(int id) {
		String sqlQuery = "SELECT * FROM todoitems WHERE id = ?";
		Object[] args = new Object[] {id};
		TodoItem item = jdbcTemplate.queryForObject(sqlQuery, args, new TodoItemRowMapper());
		return item;
	}
	
	
	
	

}
