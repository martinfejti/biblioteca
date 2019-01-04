package hu.simplesoft.springtutorial.Biblioteca.data.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Repository;

import hu.simplesoft.springtutorial.Biblioteca.data.dao.BookDao;
import hu.simplesoft.springtutorial.Biblioteca.data.entity.BookEntity;
import hu.simplesoft.springtutorial.Biblioteca.data.mapper.BookMapper;
import hu.simplesoft.springtutorial.Biblioteca.data.util.Constants;
import hu.simplesoft.sprintutorial.Biblioteca.service.dto.BookDto;

@Repository
@Transactional
public class BookDaoImpl implements BookDao{

	private static final Logger LOGGER = LogManager.getLogger(BookDaoImpl.class);
	private static final BookMapper BOOK_MAPPER = Mappers.getMapper(BookMapper.class);
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public BookDaoImpl() {
		
	}
	
	@Override
	public BookDto getBookByTitle(String title) {
		BookEntity bookEntity = entityManager.find(BookEntity.class, title);
		
		return BOOK_MAPPER.mapBookEntityToDto(bookEntity);
	}
	
	@Override
	public boolean createBook(BookDto bookDto) {
		boolean isSuccess = false;
		BookEntity newBookEntity = BOOK_MAPPER.mapBookDtoToEntity(bookDto);
		
		try {
			this.entityManager.persist(newBookEntity);
			isSuccess = true;
		} catch (RuntimeException e) {
			LOGGER.error(Constants.BookDaoErrorLogMessage.CREATE_FAILED);
		}
		
		return isSuccess;
	}
	
	@Override
	public boolean updateBook(BookDto bookDto) {
		boolean isSuccess = false;
		BookEntity newBookEntityForUpdate = entityManager.find(BookEntity.class, bookDto.getId());
		
		if(newBookEntityForUpdate != null) {
			newBookEntityForUpdate = updateBookEntity(newBookEntityForUpdate, bookDto);
			
			try {
				this.entityManager.merge(newBookEntityForUpdate);
				isSuccess = true;
			} catch(RuntimeException e) {
				LOGGER.error(Constants.BookDaoErrorLogMessage.UPDATE_FAILED);
			}
		}
		
		return isSuccess;
	}
	
	@Override
	public boolean deleteBook(long bookId) {
		boolean isSuccess = false;
		BookEntity bookEntityForDelete = entityManager.find(BookEntity.class, bookId);
		
		try {
			this.entityManager.remove(bookEntityForDelete);
			isSuccess = true;
		} catch (RuntimeException e) {
			LOGGER.error(Constants.BookDaoErrorLogMessage.DELETE_FAILED);
		}
		
		return isSuccess;
	}
	
	public BookEntity updateBookEntity(BookEntity originalBookEntity, BookDto newBookDto) {
		BookEntity newBookEntity = BOOK_MAPPER.mapBookDtoToEntity(newBookDto);
		
		originalBookEntity.setBookId(newBookEntity.getBookId());
		originalBookEntity.setTitle(newBookEntity.getTitle());
		originalBookEntity.setAuthor(newBookEntity.getAuthor());
		originalBookEntity.setCategory(newBookEntity.getCategory());
		originalBookEntity.setPublishYear(newBookEntity.getPublishYear());
		originalBookEntity.setLibrary(newBookEntity.getLibrary());
		
		return originalBookEntity;
	}
	
}
