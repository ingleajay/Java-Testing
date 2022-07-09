package com.testdoubles.fake;

import java.util.Collection;

public interface BookRepository {

	void save(Book book);
	Collection <Book> findAll();
}
