package hu.simplesoft.springtutorial.Biblioteca.data.repository;

import java.util.List;

import hu.simplesoft.springtutorial.Biblioteca.data.entity.BookEntity;
import hu.simplesoft.springtutorial.Biblioteca.data.exception.PersistenceException;

public interface BookRepository {

	void createBook(BookEntity bookEntity) throws PersistenceException;
	void updateBook(BookEntity bookEntity) throws PersistenceException;
	void deleteBook(BookEntity bookEntity) throws PersistenceException;
	BookEntity getBookById(long id) throws PersistenceException;
	List<BookEntity> getAllBooks() throws PersistenceException;
	
}
