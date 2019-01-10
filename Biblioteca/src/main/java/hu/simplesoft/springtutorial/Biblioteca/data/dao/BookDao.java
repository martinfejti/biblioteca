package hu.simplesoft.springtutorial.Biblioteca.data.dao;

import java.util.List;

import hu.simplesoft.springtutorial.Biblioteca.data.exception.ElementNotFoundException;
import hu.simplesoft.springtutorial.Biblioteca.data.exception.PersistenceException;
import hu.simplesoft.sprintutorial.Biblioteca.service.dto.BookDto;

public interface BookDao {

	void createBook(BookDto bookDto) throws PersistenceException;
	void updateBook(BookDto bookDto) throws PersistenceException;
	void deleteBook(long bookId) throws PersistenceException;
	BookDto getBookById(long bookId) throws ElementNotFoundException;
	List<BookDto> getAllBooks() throws ElementNotFoundException;
}
