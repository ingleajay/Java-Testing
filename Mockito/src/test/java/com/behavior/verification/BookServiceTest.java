package com.behavior.verification;

import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.atMostOnce;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

	@InjectMocks
	private BookService bookService;
	
	@Mock
	private BookRepository bookRepository;
	

	// it tells or verifies that book repo save method call or not or it done interaction or not
	@Test
	public void testAddBook() {
		Book book = new Book(null, "Mockito In Action", 600, LocalDate.now());
		bookService.addBook(book);
		verify(bookRepository).save(book);
	}
	
	// it basically check no of intercation with your mock object
	
	@Test
	public void testSaveBookWithBookRequestWithGreaterPrice() {
		BookRequest bookRequest = new BookRequest("Mockito In Action", 500, LocalDate.now());
		Book book = new Book(null, "Mockito In Action", 500, LocalDate.now());
		bookService.addBook(bookRequest);
		verify(bookRepository, times(0)).save(book);
	}
	
	@Test
	public void testSaveBookWithBookRequestWithGreaterPrice1() {
		BookRequest bookRequest = new BookRequest("Mockito In Action", 600, LocalDate.now());
		Book book = new Book(null, "Mockito In Action", 600, LocalDate.now());
		bookService.addBook(bookRequest);
		bookService.addBook(bookRequest);
		verify(bookRepository, times(2)).save(book);
	}
	
// never() it tells that it mock with zero interaction 
	@Test
	public void testSaveBookWithBookRequestWithGreaterPrice2() {
		BookRequest bookRequest = new BookRequest("Mockito In Action", 500, LocalDate.now());
		Book book = new Book(null, "Mockito In Action", 500, LocalDate.now());
		bookService.addBook(bookRequest);
		verify(bookRepository, never()).save(book);
	}
	
	// this method will tell you there is no intercation
	@Test
	public void testUpdatePrice() {
		bookService.updatePrice(null, 600);
		verifyNoInteractions(bookRepository);
	}
	
	// update price and get to know if there is same price then no need to update price
	@Test
	public void testUpdatePrice1() {
		Book book = new Book("1234", "Mockito In Action", 500, LocalDate.now());
		when(bookRepository.findBookById("1234")).thenReturn(book);
		bookService.updatePrice("1234", 500);
		verify(bookRepository).findBookById("1234");
		
		//if you don't want condition in your service class like price related line no 38 then use below
		verify(bookRepository).save(book);
		verifyNoMoreInteractions(bookRepository);
	}
	
	// verifiy order of intercations
	// from this example we are not sure that mock object created before or after so minatain order
	// findbookid should be before save method
		@Test
		public void testUpdatePrice2() {
			Book book = new Book("1234", "Mockito In Action", 500, LocalDate.now());
			when(bookRepository.findBookById("1234")).thenReturn(book);
			bookService.updatePrice("1234", 500);
			InOrder inorder = Mockito.inOrder(bookRepository);
//			inorder.verify(bookRepository).save(book);
//			inorder.verify(bookRepository).findBookById("1234");
		}
	
		// verify an intercation occurs a certain no of times..

		@Test
		public void testSaveBookWithBookRequestWithGreaterPrice4() {
			BookRequest bookRequest = new BookRequest("Mockito In Action", 600, LocalDate.now());
			Book book = new Book(null, "Mockito In Action", 600, LocalDate.now());
			bookService.addBook(bookRequest);
			bookService.addBook(bookRequest);
			//verify(bookRepository, times(0)).save(book);
			//verify(bookRepository, atLeast(1)).save(book);
			//verify(bookRepository, atMost(2)).save(book);
			//verify(bookRepository, atMostOnce()).save(book);
			verify(bookRepository,atLeastOnce()).save(book);
		}
}
