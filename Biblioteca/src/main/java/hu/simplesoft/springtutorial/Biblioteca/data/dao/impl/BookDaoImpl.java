package hu.simplesoft.springtutorial.Biblioteca.data.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import hu.simplesoft.springtutorial.Biblioteca.data.dao.BookDao;
import hu.simplesoft.springtutorial.Biblioteca.data.entity.BookEntity;
import hu.simplesoft.springtutorial.Biblioteca.data.exception.ElementNotFoundException;
import hu.simplesoft.springtutorial.Biblioteca.data.exception.ObjectIsNullException;
import hu.simplesoft.springtutorial.Biblioteca.data.exception.PersistenceException;
import hu.simplesoft.springtutorial.Biblioteca.data.mapper.BookMapper;
import hu.simplesoft.springtutorial.Biblioteca.data.repository.BookRepository;
import hu.simplesoft.springtutorial.Biblioteca.data.util.Validator;
import hu.simplesoft.sprintutorial.Biblioteca.service.dto.BookDto;

@Component
public class BookDaoImpl implements BookDao{

	private BookRepository bookRepository;
	
	public BookDaoImpl() {
	}
	
	@Override
	public BookDto getBookById(long bookId) throws ElementNotFoundException, ObjectIsNullException{
		BookEntity bookEntity = this.bookRepository.getBookById(bookId);
		
		Validator.validateObject(bookEntity, bookId);
		
		return BookMapper.convertEntityToDto(bookEntity);
	}
	
	@Override
	public List<BookDto> getAllBooks() throws ElementNotFoundException{
		List<BookEntity> bookEntityList = this.bookRepository.getAllBooks();
		
		return BookMapper.convertListEntityToDto(bookEntityList);
	}
	
	@Override
	public void createBook(BookDto bookDto) throws PersistenceException{
		BookEntity newBookEntity = BookMapper.convertDtoToEntity(bookDto);

		this.bookRepository.createBook(newBookEntity);
	}
	
	@Override
	public void updateBook(BookDto bookDto) throws PersistenceException, ObjectIsNullException{
		BookEntity newBookEntityForUpdate = this.bookRepository.getBookById(bookDto.getId());
		
		Validator.validateObject(newBookEntityForUpdate, bookDto.getId());
		
		if(newBookEntityForUpdate != null) {
			newBookEntityForUpdate = updateBookEntity(newBookEntityForUpdate, bookDto);
			
			this.bookRepository.updateBook(newBookEntityForUpdate);
		}
	}
	
	@Override
	public void deleteBook(long bookId) throws PersistenceException, ObjectIsNullException{
		BookEntity bookEntityForDelete = this.bookRepository.getBookById(bookId);
		
		Validator.validateObject(bookEntityForDelete, bookId);
		
		this.bookRepository.deleteBook(bookEntityForDelete);
		
	}
	
	public BookEntity updateBookEntity(BookEntity originalBookEntity, BookDto newBookDto) {
		BookEntity newBookEntity = BookMapper.convertDtoToEntity(newBookDto);
		
		originalBookEntity.setBookId(newBookEntity.getBookId());
		originalBookEntity.setTitle(newBookEntity.getTitle());
		originalBookEntity.setAuthor(newBookEntity.getAuthor());
		originalBookEntity.setCategory(newBookEntity.getCategory());
		originalBookEntity.setPublishYear(newBookEntity.getPublishYear());
		originalBookEntity.setLibrary(newBookEntity.getLibrary());
		
		return originalBookEntity;
	}
	
}
