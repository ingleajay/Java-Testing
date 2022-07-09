package com.testannotation.mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.junit.jupiter.MockitoExtension;

import com.testdoubles.stub.Book;
import com.testdoubles.stub.BookRepository;
import com.testdoubles.stub.BookService;

//@ExtendWith(MockitoExtension.class)
public class AnnotationMockOnStub {
	
	// @Mock => It used for mock book repo and injected into book service class
	// @Inject => It used as class under test like book service - in which service you want do test
	
	// if we use Junit 4 then use @RunWith(MockitoJunitRunner.class) and change import of all annotation
	// according to junit 4
	
	// We have three ways  : 
	// 1. use extend With - junit 5
	// 2. use run with  - junit 4
	// 3. use before or beforeEach  - junit 4 or junit 5
	// 4. use junit 4 - rule annottaion it's not in junit 5
	// --> @Rule should be public
	//@Rule
	//public MockitoRule mockitoRule = MockitoJUnit.rule();
	
	
	@InjectMocks
	private BookService bookService;
	
	@Mock
	private BookRepository bookRepository;
	
	@BeforeEach
	public void beforeEach() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void demoStubWithMockito(){
		//BookService bookService = new BookService(bookRepository);
		
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
