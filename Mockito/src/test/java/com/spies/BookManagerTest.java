package com.spies;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.speis.Book;
import com.speis.BookManager;
import com.speis.BookService;


@ExtendWith(MockitoExtension.class)
public class BookManagerTest {

	@InjectMocks
	private BookManager bookManager;
	
	@Spy
	private BookService bookService;
	
	// Here we use spy object , actually we have not create mock object simply use spy for bookservice 
	//so that we will not test external dependency service like findBook we can direcly use applydiscountbook method 
	
	@Test
	public void testMockitoSpy(){
		// We need to mock findBook because it is communicating to database or not implemented
		// We need to call getAppliedDiscount to calculate the discounted price
		Book book = new Book("1234", "Mockito In Action", 500, LocalDate.now());
		doReturn(book).when(bookService).findBook("1234");
		
		// when we use when then it return exception so use doreturn 
//		when(bookService.findBook("1234")).thenReturn(book);
		int actualDiscount = bookManager.applyDiscountOnBook("1234", 10);
		assertEquals(450, actualDiscount);
	}
	
}