package hu.simplesoft.springtutorial.Biblioteca.data.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import hu.simplesoft.springtutorial.Biblioteca.data.entity.AuthorEntity;
import hu.simplesoft.springtutorial.Biblioteca.data.exception.ElementNotFoundException;
import hu.simplesoft.springtutorial.Biblioteca.data.exception.PersistenceException;
import hu.simplesoft.springtutorial.Biblioteca.data.repository.AuthorRepository;

@Repository
@Transactional
public class AuthorRepositoryImpl implements AuthorRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	public AuthorRepositoryImpl() {
	}
	
	@Override
	public AuthorEntity getAuthorById(long authorId) throws PersistenceException{
		AuthorEntity foundEntity;
		
		try {
			foundEntity = this.entityManager.find(AuthorEntity.class, authorId);
		} catch (RuntimeException e) {
			throw new ElementNotFoundException("Element not found!", e);
		}
		
		return foundEntity;
	}
	
	@Override
	public List<AuthorEntity> getAllAuthors() throws PersistenceException{
		List<AuthorEntity> authorEntityList;
		
		try {
			TypedQuery<AuthorEntity> query = this.entityManager.createQuery("SELECT a FROM Author a", AuthorEntity.class);
			authorEntityList = query.getResultList();
		} catch (RuntimeException e) {
			throw new ElementNotFoundException("Element not found!", e);
		}
		
		return authorEntityList;
	}
	
	@Override
	public void createAuthor(AuthorEntity authorEntity) throws PersistenceException{
		
		try {
			this.entityManager.persist(authorEntity);
		} catch (RuntimeException e) {
			throw new PersistenceException("Create has failed!", e);
		}
	}
	
	@Override
	public void updateAuthor(AuthorEntity authorEntity) throws PersistenceException{
		
		try {
			this.entityManager.merge(authorEntity);
		} catch (RuntimeException e) {
			throw new PersistenceException("Update has failed!", e);
		}
	}
	
	@Override
	public void deleteAuthor(AuthorEntity authorEntity) throws PersistenceException{
		
		try {
			this.entityManager.remove(authorEntity);
		} catch (RuntimeException e) {
			throw new PersistenceException("Delete has failed!", e);
		}
	}
}
