package com.test.Junit5.Assert;

public class Book {

	public int bid;
	public String bname;
	public String bauthor;
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getBauthor() {
		return bauthor;
	}
	public void setBauthor(String bauthor) {
		this.bauthor = bauthor;
	}
	public Book(int bid, String bname, String bauthor) {
		super();
		this.bid = bid;
		this.bname = bname;
		this.bauthor = bauthor;
	}
	public Book() {
		super();
	}
	@Override
	public String toString() {
		return "Book [bid=" + bid + ", bname=" + bname + ", bauthor=" + bauthor + "]";
	}
}
