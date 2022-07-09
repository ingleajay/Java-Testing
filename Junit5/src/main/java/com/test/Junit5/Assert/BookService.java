package com.test.Junit5.Assert;

import java.util.ArrayList;
import java.util.List;

import com.test.Junit5.Assert.exception.BookNotFoundException;

public class BookService {
	
	private List<Book> lbook = new ArrayList<>();
	
	public List<Book> books(Book b) {
		b= new Book(101,"Test 1","Ajay");
		lbook.add(b);
		return lbook;
	}
	public List<Book> books() {
		Book b= new Book(101,"Test 1","Ajay");
		lbook.add(b);
		return lbook;
	}
	
	public String[] getIdofBookByName(String bname) {
		ArrayList<String> ids = new ArrayList<String>();
		for(Book b : lbook) {
			if(bname.equals(b.getBauthor())) {
				ids.add(String.valueOf(b.getBid()));
			}
		}
		return ids.toArray(new String[ids.size()]);
	}

	
	public ArrayList<String> getIdofBookByName1(String bname) {
		ArrayList<String> ids = new ArrayList<String>();
		for(Book b : lbook) {
			if(bname.equals(b.getBauthor())) {
				ids.add(String.valueOf(b.getBid()));
			}
		}
		return ids;
	}
	
	public ArrayList<String> getTitleofBookByName(String bname) {
		ArrayList<String> title = new ArrayList<String>();
		for(Book b : lbook) {
			if(bname.equals(b.getBname())) {
			 title.add(b.getBname());
			}
		}
		return title;
	}
	
	
	public Book getBookById(String bookid) {
		for(Book book:lbook) {
			if(bookid.equals(book.getBid())) {
				return book;
			}
		}
		throw new BookNotFoundException("Book not found in book store..");
	}
	
	
}
