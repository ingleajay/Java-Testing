package com.test.Junit5.asserts;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.test.Junit5.Assert.Book;
import com.test.Junit5.Assert.BookService;

public class AssertNotEqual {

	 BookService bservice = new BookService();
	 List<Book> lbook = bservice.books();
	 
	 @Test
	 public void assertEqualWithNoMsg() {
		 assertNotEquals(101,new Book().getBid());
	 }
		
	 @Test
	 public void assertEqualWithMsg() {
		 assertNotEquals("Ajay",new Book().getBauthor(), "Author name is incorrect");
	 }
	 
	 @Test
	 public void assertEqualWithSupplierMsg() {
		 assertNotEquals("Test 1", new Book().getBname(), ()->"Author name is incorrect");
	 }
}

