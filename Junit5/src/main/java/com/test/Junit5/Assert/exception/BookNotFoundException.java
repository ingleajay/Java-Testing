package com.test.Junit5.Assert.exception;

public class BookNotFoundException extends RuntimeException{

	public BookNotFoundException(String message) {
		super(message);
	}
}

