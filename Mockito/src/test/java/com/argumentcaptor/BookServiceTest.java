package com.argumentcaptor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.argumentcaptor.Book;
import com.argumentcaptor.BookRepository;
import com.argumentcaptor.BookRequest;
import com.argumentcaptor.BookService;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

	@InjectMocks
	private BookService bookService;
	
	@Mock
	private BookRepository bookRepository;
	

	@Captor
	private ArgumentCaptor<Book> bookArgumentCaptor;
	
	
	
	@Test
	public void testSaveBookNoAnnotation() {
		BookRequest bookRequest = new BookRequest("Mockito In Action", 500, LocalDate.now());
		ArgumentCaptor<Book> bookArgumentCaptor = ArgumentCaptor.forClass(Book.class);
		bookService.addBook(bookRequest);
		verify(bookRepository).save(bookArgumentCaptor.capture());
		Book book = bookArgumentCaptor.getValue();
		assertEquals("Mockito In Action", book.getTitle());
	}
	
	@Test
	public void testSaveBookWithAnnotation() {
		BookRequest bookRequest = new BookRequest("Mockito In Action", 500, LocalDate.now());
		bookService.addBook(bookRequest);
		verify(bookRepository).save(bookArgumentCaptor.capture());
		Book book = bookArgumentCaptor.getValue();
		assertEquals("Mockito In Action", book.getTitle());
	}

}
