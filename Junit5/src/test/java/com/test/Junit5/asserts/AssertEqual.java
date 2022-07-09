package com.test.Junit5.asserts;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.test.Junit5.Assert.Book;
import com.test.Junit5.Assert.BookService;

public class AssertEqual {

	 BookService bservice = new BookService();
	 List<Book> lbook = bservice.books();
	 
	 @Test
	 public void assertEqualWithNoMsg() {
		 assertEquals(101,lbook.get(0).getBid());
	 }
		
	 @Test
	 public void assertEqualWithMsg() {
		 assertEquals("Ajay", lbook.get(0).getBauthor(), "Author name is incorrect");
	 }
	 
	 @Test
	 public void assertEqualWithSupplierMsg() {
		 assertEquals("Test 1", lbook.get(0).getBname(), ()->"Author name is incorrect");
	 }
	 
	 
}
