package com.test.Junit5.asserts;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.test.Junit5.Assert.Book;
import com.test.Junit5.Assert.BookService;

public class ArrayItearableEqual {

	BookService bservice = new BookService();
	List<Book> lbook = bservice.books();

	@Test
	public void assertItearbleEqualWithNoMsg() {
		
		ArrayList<String> ids = bservice.getIdofBookByName1("Ajay");
		ArrayList<String> eid = new ArrayList<String>();
		eid.add("101");
		assertIterableEquals(eid, ids);
	}
	
	@Test
	public void assertItearbleEqualWithMsg() {
		
		ArrayList<String> ids = bservice.getIdofBookByName1("Ajay");
		ArrayList<String> eid = new ArrayList<String>();
		eid.add("101");
		assertIterableEquals(eid, ids,"This id not present");
	}
	
	@Test
	public void assertItearbleEqualWithSupplierMsg() {
		
		ArrayList<String> ids = bservice.getIdofBookByName1("Ajay");
		ArrayList<String> eid = new ArrayList<String>();
		eid.add("101");
		assertIterableEquals(eid, ids,()->"This id not present");
	}
}
