package com.testdoubles.dummy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.jupiter.api.Test;

public class DummyTest {
	
	// If we have more extrenal dependecy then to avoid testing of that we create dummy service which used to only for compling

	@Test
	public void demodummy() {
		BookRepository bookRepository = new FakeBookRepository();
		EmailService emailService = new DummyEmailService();
		BookService bookService = new BookService(bookRepository,emailService);
		
		bookService.addBook(new Book("1234", "Mockito In Action", 250, LocalDate.now()));
		bookService.addBook(new Book("1235", "JUnit 5 In Action", 200, LocalDate.now()));
		
		assertEquals(2, bookService.findNumberOfBooks());
	}
	
	@Test
	public void demoDummyWithMockito() {
		BookRepository bookRepository = mock(BookRepository.class);
		EmailService emailService = mock(EmailService.class);
		BookService bookService = new BookService(bookRepository, emailService);
		
		Book book1 = new Book("1234", "Mockito In Action", 250, LocalDate.now());
		Book book2 = new Book("1235", "JUnit 5 In Action", 200, LocalDate.now());
		
		Collection<Book> books = new ArrayList<>();
		books.add(book1);
		books.add(book2);
		
		when(bookRepository.findAll()).thenReturn(books);
		
		assertEquals(2, bookService.findNumberOfBooks());
	}
}
