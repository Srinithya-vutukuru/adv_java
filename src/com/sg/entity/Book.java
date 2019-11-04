package com.sg.entity;

import com.sg.Column;
import com.sg.Table;

@Table(name="books")
public class Book {
	
	private int id;
	
	private String title;
	
	private double price;

	public Book() {
	}

	public Book(int id, String title, double price) {
		this.id = id;
		this.title = title;
		this.price = price;
	}
	
	@Column(name="book_id", type="NUMERRIC(10)")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="title")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	@Column(name="amount", type="NUMERRIC(12,2)")
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
