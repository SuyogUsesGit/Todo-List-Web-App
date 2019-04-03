package com.suyoggaikwad.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

import com.suyoggaikwad.dao.TodoItemDaoImpl;

import lombok.NonNull;

public class TodoData {
	
	private int id = 1;
	private List<TodoItem> list = new ArrayList<>();
	
	public TodoData() {

//		addItem(new TodoItem("first", "first details", LocalDate.now()));
//        addItem(new TodoItem("second", "second details", LocalDate.now()));
//        addItem(new TodoItem("third", "third details", LocalDate.now()));
	}
	
	public void addItem(@NonNull TodoItem item) {
		item.setId(id);
		id++;
		list.add(item);
	}
	
	public TodoItem getItem(int id) {
		ListIterator<TodoItem> li = list.listIterator();
		while(li.hasNext()) {
			TodoItem temp = li.next();
			if(temp.getId() == id) {
				return temp;
			}
		}
		return null;
	}
	
	public void removeItem(int id) {
		ListIterator<TodoItem> li = list.listIterator();
		while(li.hasNext()) {
			TodoItem temp = li.next();
			if(temp.getId() == id) {
				li.remove();
			}
		}
	}
	
	public void updateItem(@NonNull TodoItem itemToUpdate) {
		ListIterator<TodoItem> li = list.listIterator();
		while(li.hasNext()) {
			TodoItem temp = li.next();
			if(temp.getId() == itemToUpdate.getId()) {
				li.set(itemToUpdate);
			}
		}
	}
	
	public List<TodoItem> getItems() {
		return Collections.unmodifiableList(list);
	}
	
}
