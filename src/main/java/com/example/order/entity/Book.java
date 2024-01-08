package com.example.order.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Book {

	@Id
	private Integer bookId;
	private String bookName;
	private Double bookprice;

	public int getbookId() {
		return bookId;
	}

	public void setbookId(int bookId) {
		this.bookId = bookId;
	}

	public String getbookName() {
		return bookName;
	}

	public void setbookName(String bookName) {
		this.bookName = bookName;
	}

	public double getbookprice() {
		return bookprice;
	}

	public void setbookprice(double bookprice) {
		this.bookprice = bookprice;
	}

}
