package com.test.Junit5.asserts;

import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.test.Junit5.Assert.Book;
import com.test.Junit5.Assert.BookService;

public class AssertNull {

    BookService bservice = new BookService();
	List<Book> lbook = bservice.books();
	
	@Test
	public void assertNullWithNoMsg() {
		Book book = null;
		assertNull(book);
	}
	
	@Test
	public void assertNullWithMsg() {
		Book book = null;
		assertNull(book,"There is book added already!!");
	}
	
	@Test
	public void assertNullWithSupplierMsg() {
		Book book = null;
		assertNull(book,()->"There is book added already!!");
	}
}
