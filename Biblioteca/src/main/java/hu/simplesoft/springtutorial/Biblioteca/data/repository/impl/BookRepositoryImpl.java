package hu.simplesoft.springtutorial.Biblioteca.data.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import hu.simplesoft.springtutorial.Biblioteca.data.entity.BookEntity;
import hu.simplesoft.springtutorial.Biblioteca.data.exception.ElementNotFoundException;
import hu.simplesoft.springtutorial.Biblioteca.data.exception.PersistenceException;
import hu.simplesoft.springtutorial.Biblioteca.data.repository.BookRepository;

@Repository
@Transactional
public class BookRepositoryImpl implements BookRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	public BookRepositoryImpl() {
	}
	
	@Override
	public BookEntity getBookById(long bookId) throws PersistenceException{
		BookEntity bookEntity;
		
		try {
			bookEntity = this.entityManager.find(BookEntity.class, bookId);
		} catch (RuntimeException e) {
			throw new ElementNotFoundException("Element not found!", e);
		}
		
		return bookEntity;
	}
	
	@Override
	public List<BookEntity> getAllBooks() throws PersistenceException{
		List<BookEntity> bookEntityList;
		
		try {
			TypedQuery<BookEntity> query = this.entityManager.createQuery("SELECT b FROM Book b", BookEntity.class);
			bookEntityList = query.getResultList();
		} catch (RuntimeException e) {
			throw new ElementNotFoundException("Element not found!", e);
		}
		
		return bookEntityList;
	}
	
	@Override
	public void createBook(BookEntity bookEntity) throws PersistenceException{
		
		try {
			this.entityManager.persist(bookEntity);
		} catch (RuntimeException e) {
			throw new PersistenceException("Create has failed!", e);
		}
	}
	
	@Override
	public void updateBook(BookEntity bookEntity) throws PersistenceException{
		
		try {
			this.entityManager.merge(bookEntity);
		} catch (RuntimeException e) {
			throw new PersistenceException("Update has failed!", e);
		}
	}
	
	@Override
	public void deleteBook(BookEntity bookEntity) throws PersistenceException{
		
		try {
			this.entityManager.remove(bookEntity);
		} catch (RuntimeException e) {
			throw new PersistenceException("Delete has failed!", e);
		}
	}
}
