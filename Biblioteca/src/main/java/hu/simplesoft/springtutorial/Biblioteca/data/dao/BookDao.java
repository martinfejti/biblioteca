package hu.simplesoft.springtutorial.Biblioteca.data.dao;

import hu.simplesoft.sprintutorial.Biblioteca.service.dto.BookDto;

public interface BookDao {

	boolean createBook(BookDto bookDto);
	boolean updateBook(BookDto bookDto);
	boolean deleteBook(long bookId);
	BookDto getBookById(String title);
}
