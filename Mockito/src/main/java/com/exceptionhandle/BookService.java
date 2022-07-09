package com.exceptionhandle;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BookService {

	private BookRepository bookRepository;
	
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	public int getTotalPriceOfBooks() {
		List<Book> books = new ArrayList<Book>();
		try {
			books = bookRepository.findAllBooks();
		} catch (SQLException e) {
			// log exception
			throw new DatabaseReadException("Unable to read from database due to - " + e.getMessage());
		}
		int totalPrice = 0;
		for(Book book : books){
			totalPrice = totalPrice + book.getPrice();
		}
		return totalPrice;
	}
	public void addBook(Book book){
		try {
			bookRepository.save(book);
		} catch (SQLException e) {
			// log exception
			throw new DatabaseWriteException("Unable to write in database due to - " + e.getMessage());
		}
	}
}
