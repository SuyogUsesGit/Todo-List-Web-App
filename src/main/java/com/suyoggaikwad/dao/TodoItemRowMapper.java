package com.suyoggaikwad.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.suyoggaikwad.domain.TodoItem;

public class TodoItemRowMapper implements RowMapper<TodoItem> {

	@Override
	public TodoItem mapRow(ResultSet rs, int rowNum) throws SQLException {
		TodoItem todoItem = new TodoItem();
		todoItem.setId(rs.getInt("id"));
		todoItem.setTitle(rs.getString("title"));
		todoItem.setDetails(rs.getString("details"));
		todoItem.setDate(rs.getDate("date").toLocalDate());
		return todoItem;
	}

}
