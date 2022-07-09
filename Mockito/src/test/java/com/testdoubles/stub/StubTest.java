package com.testdoubles.stub;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class StubTest {
	
	// Stub means to create stub of your repo and it's hard coded logic written
	// it is not testing to db 

	@Test
	public void demoStub(){
		BookRepository bookRepository = new BookRepositoryStub();
		BookService bookService = new BookService(bookRepository);
		
		List<Book> newBooksWithAppliedDiscount = bookService.getNewBooksWithAppliedDiscount(10);
		
		assertEquals(2, newBooksWithAppliedDiscount.size());
		assertEquals(450, newBooksWithAppliedDiscount.get(0).getPrice());
		assertEquals(360, newBooksWithAppliedDiscount.get(1).getPrice());
	}
	

	@Test
	public void demoStubWithMockito(){
		BookRepository bookRepository = mock(BookRepository.class);
		BookService bookService = new BookService(bookRepository);
		
		Book book1 = new Book("1234", "Mockito In Action", 500, LocalDate.now());
		Book book2 = new Book("1235", "JUnit 5 In Action", 400, LocalDate.now());
		
		List<Book> newBooks = new ArrayList<>();
		newBooks.add(book1);
		newBooks.add(book2);
		
		when(bookRepository.findNewBooks()).thenReturn(newBooks);
		
		List<Book> newBooksWithAppliedDiscount = bookService.getNewBooksWithAppliedDiscount(10);
		
		assertEquals(2, newBooksWithAppliedDiscount.size());
		assertEquals(450, newBooksWithAppliedDiscount.get(0).getPrice());
		assertEquals(360, newBooksWithAppliedDiscount.get(1).getPrice());
	}
}
