package com.test.Junit5.asserts;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.test.Junit5.Assert.Book;
import com.test.Junit5.Assert.BookService;

public class AssertTimeOut {

	@Test
	public void assertTimeoutWithNoMessage() {
		BookService bookService = new BookService();
		
		for(int i = 1; i <= 1000; i++) {
			bookService.books(new Book(i, "Test 1", "Ajay"));
		}
		
		List<String> actualTitles = new ArrayList<>();
		
		assertTimeout(Duration.ofMillis(1), () -> {
			actualTitles.addAll(bookService.getTitleofBookByName("Test 1"));
		});
		assertEquals(1000, actualTitles.size());
		
	}
	
	@Test
	public void assertTimeoutWithMessage() {
		BookService bookService = new BookService();
		
		for(int i = 1; i <= 1000; i++) {
			bookService.books(new Book(i, "Test 1", "Ajay"));
		}
		
		List<String> actualTitles = new ArrayList<>();
		
		assertTimeout(Duration.ofMillis(1), () -> {
			actualTitles.addAll(bookService.getTitleofBookByName("Test 1"));
		},"Perform issue with time ");
		assertEquals(1000, actualTitles.size());
		
	}
	
	@Test
	public void assertTimeoutWithSupplierMessage() {
		BookService bookService = new BookService();
		
		for(int i = 1; i <= 1000; i++) {
			bookService.books(new Book(i, "Test 1", "Ajay"));
		}
		
		List<String> actualTitles = new ArrayList<>();
		
		assertTimeout(Duration.ofMillis(1), () -> {
			actualTitles.addAll(bookService.getTitleofBookByName("Test 1"));
		},()->"Perform issue with time ");
		assertEquals(1000, actualTitles.size());
		
	}
}
