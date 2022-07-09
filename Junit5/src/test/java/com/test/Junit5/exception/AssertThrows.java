package com.test.Junit5.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.test.Junit5.Assert.Book;
import com.test.Junit5.Assert.BookService;
import com.test.Junit5.Assert.exception.BookNotFoundException;

public class AssertThrows {

	 BookService bservice = new BookService();
	 List<Book> lbook = bservice.books();
	 
	 @Test
	 public void assertThrowWithNoMsg() {
		 assertThrows(BookNotFoundException.class,()->bservice.getBookById("101"));
	 }
	 
	 @Test
	 public void assertThrowWithMsg() {
		 BookNotFoundException bookNotFoundException= assertThrows(BookNotFoundException.class,()->bservice.getBookById("101"),"Book exception....");
		 assertEquals("Book not found in book store..",bookNotFoundException.getMessage());
	 }
	 
	 @Test
	 public void assertThrowWithSupplierMsg() {
		 assertThrows(NullPointerException.class,()->bservice.getBookById("101"),()->"Book exception....");
	 }
}
