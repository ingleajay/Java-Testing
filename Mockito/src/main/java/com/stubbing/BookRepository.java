package com.stubbing;

import java.util.List;

public interface BookRepository {

	List<Book> findNewBooks();

	Book findBookByBookId(String bookId);

	void save(Book book);
}
