package hu.simplesoft.springtutorial.Biblioteca.data.dao;

import java.util.List;

import hu.simplesoft.springtutorial.Biblioteca.data.exception.ObjectIsNullException;
import hu.simplesoft.springtutorial.Biblioteca.data.exception.PersistenceException;
import hu.simplesoft.sprintutorial.Biblioteca.service.dto.BookDto;

public interface BookDao {

	void createBook(BookDto bookDto) throws PersistenceException;
	void updateBook(BookDto bookDto) throws PersistenceException, ObjectIsNullException;
	void deleteBook(long bookId) throws PersistenceException, ObjectIsNullException;
	BookDto getBookById(long bookId) throws PersistenceException, ObjectIsNullException;
	List<BookDto> getAllBooks() throws PersistenceException;
}
