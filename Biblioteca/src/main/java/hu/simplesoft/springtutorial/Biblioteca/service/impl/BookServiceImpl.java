package hu.simplesoft.springtutorial.Biblioteca.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.simplesoft.springtutorial.Biblioteca.data.dao.BookDao;
import hu.simplesoft.springtutorial.Biblioteca.data.exception.PersistenceException;
import hu.simplesoft.springtutorial.Biblioteca.service.BookService;
import hu.simplesoft.springtutorial.Biblioteca.service.exception.ServiceException;
import hu.simplesoft.sprintutorial.Biblioteca.service.dto.BookDto;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	private BookDao bookDao;
	
	@Override
	public void createBook(BookDto bookDto) throws ServiceException{
		try {
			this.bookDao.createBook(bookDto);
		} catch (PersistenceException e) {
			throw new ServiceException("Create has failed!", e);
		}
	}
	
	@Override
	public void updateBook(BookDto bookDto) throws ServiceException{
		try {
			this.bookDao.updateBook(bookDto);
		} catch (PersistenceException e) {
			throw new ServiceException("Update has failed!", e);
		}
	}
	
	@Override
	public void deleteBook(long bookId) throws ServiceException{
		try {
			this.bookDao.deleteBook(bookId);
		} catch (PersistenceException e) {
			throw new ServiceException("Delete has failed!", e);
		}
	}
	
	@Override
	public BookDto getBookById(long bookId) throws ServiceException{
		try {
			return this.bookDao.getBookById(bookId);
		} catch (PersistenceException e) {
			throw new ServiceException("Element not found!", e);
		}
	}
	
	@Override
	public List<BookDto> getAllBooks() throws ServiceException{
		try {
			return this.bookDao.getAllBooks();
		} catch (PersistenceException e) {
			throw new ServiceException("Element not found!", e);
		}
	}
}
