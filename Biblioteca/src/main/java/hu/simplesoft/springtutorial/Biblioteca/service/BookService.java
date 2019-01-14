package hu.simplesoft.springtutorial.Biblioteca.service;

import java.util.List;

import hu.simplesoft.springtutorial.Biblioteca.service.exception.ServiceException;
import hu.simplesoft.sprintutorial.Biblioteca.service.dto.BookDto;

public interface BookService {
	
	void createBook(BookDto bookDto) throws ServiceException;
	void updateBook(BookDto bookDto) throws ServiceException;
	void deleteBook(long bookId) throws ServiceException;
	BookDto getBookById(long bookId) throws ServiceException;
	List<BookDto> getAllBooks() throws ServiceException;
}
