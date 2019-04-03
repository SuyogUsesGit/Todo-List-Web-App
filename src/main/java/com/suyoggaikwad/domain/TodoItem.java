package com.suyoggaikwad.domain;

import java.time.LocalDate;

public class TodoItem {
	
	private int id;
	private String title;
	private String details;
	private LocalDate date;
	
	public TodoItem() {
		
	}
	
	public TodoItem(String title, String details, LocalDate date) {
		this.title = title;
		this.details = details;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	
	
}
