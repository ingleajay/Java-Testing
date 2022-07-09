package com.test.Junit5.asserts;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;
import java.util.function.Supplier;

import org.junit.jupiter.api.Test;

import com.test.Junit5.Assert.Book;
import com.test.Junit5.Assert.BookService;

public class AssertFalse {
	
	BookService bservice = new BookService();
	
	List<Book> lbook = bservice.books();
	
	@Test
	public void assertWithBooleanWithoutMsg() {
		assertFalse((lbook.isEmpty()));
	}
	
	@Test
	public void assertWithBooleanWithMsg()  {
		assertFalse(lbook.get(0).bauthor.equals("Vijay"), "Author name is incorrect");
	}
	
	@Test
	public void assertWithBooleanWithSupplierMsg() {
		Supplier<String> msg = ()->{return "Length is not more than 3";};
		for(Book b : lbook) {
			assertFalse(String.valueOf(b.getBid()).length()!=3 ? true : false,msg.get());
		}
	}
	
	@Test
	public void assertWithBooleanSupplier() {
		for(Book b : lbook) {
			assertFalse(()->b.bauthor.length()==0 ? true : false);
		}
	}
	
	@Test
	public void assertWithBooleanSupplierWithMsg() {
		for(Book b : lbook) {
			assertFalse(()->b.bauthor.length()==0 ? true : false, "Author length should less orequal to 5");
		}
	}
	
	@Test
	public void assertWithBooleanSupplierWithSupplierMsg() {
		for(Book b : lbook) {
			assertFalse(()->b.bauthor.length()==0 ? true : false, ()->"Author length should less orequal to 5");
		}
	}
	
}
