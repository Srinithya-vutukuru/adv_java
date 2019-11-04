package com.sg.client;

import com.sg.entity.Book;
import com.sg.util.SQLUtil;

public class SQLClient {
	
	public static void main(String... args) {
		String CREATE_SQL = SQLUtil.getCreateStatement(Book.class);
		System.out.println(CREATE_SQL);
		
		Book b1 = new Book(34,"Alchemist",450.00);
		System.out.println(SQLUtil.getInsertSQL(b1));
	}

}
