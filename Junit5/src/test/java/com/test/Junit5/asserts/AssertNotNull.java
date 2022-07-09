package com.test.Junit5.asserts;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.test.Junit5.Assert.Book;
import com.test.Junit5.Assert.BookService;

public class AssertNotNull {

	BookService bservice = new BookService();
	List<Book> lbook = bservice.books();
	
	@Test
	public void assertNullWithNoMsg() {
		assertNotNull(lbook);
	}
	
	@Test
	public void assertNullWithMsg() {
		assertNotNull(lbook,"There is book added already!!");
	}
	
	@Test
	public void assertNullWithSupplierMsg() {
		assertNotNull(lbook,()->"There is book added already!!");
	}
}
