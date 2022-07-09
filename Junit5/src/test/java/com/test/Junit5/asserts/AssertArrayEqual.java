package com.test.Junit5.asserts;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.test.Junit5.Assert.Book;
import com.test.Junit5.Assert.BookService;

public class AssertArrayEqual {
	BookService bservice = new BookService();
	List<Book> lbook = bservice.books();

	@Test
	public void assertArrayEqualWithNoMsg() {
		
		String[] ids = bservice.getIdofBookByName("Ajay");
		assertArrayEquals(new String[]{"101"}, ids);
	}
	
	@Test
	public void assertArrayEqualWithMsg() {
		
		String[] ids = bservice.getIdofBookByName("Ajay");
		assertArrayEquals(new String[]{"102"}, ids,"This id not present");
	}
	
	@Test
	public void assertArrayEqualWithSupplierMsg() {
		
		String[] ids = bservice.getIdofBookByName("Ajay");
		assertArrayEquals(new String[]{"101"}, ids,()->"This id not present");
	}
}
