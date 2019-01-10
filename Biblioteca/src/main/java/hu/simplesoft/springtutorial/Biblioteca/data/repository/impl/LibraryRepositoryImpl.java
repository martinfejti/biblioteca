package hu.simplesoft.springtutorial.Biblioteca.data.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import hu.simplesoft.springtutorial.Biblioteca.data.entity.LibraryEntity;
import hu.simplesoft.springtutorial.Biblioteca.data.exception.ElementNotFoundException;
import hu.simplesoft.springtutorial.Biblioteca.data.exception.PersistenceException;
import hu.simplesoft.springtutorial.Biblioteca.data.repository.LibraryRepository;

@Repository
@Transactional
public class LibraryRepositoryImpl implements LibraryRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	public LibraryRepositoryImpl() {
	}
	
	@Override
	public LibraryEntity getLibraryById(long libraryId) throws ElementNotFoundException{
		LibraryEntity libraryEntity;
		
		try {
			libraryEntity = this.entityManager.find(LibraryEntity.class, libraryId);
		} catch (RuntimeException e) {
			throw new ElementNotFoundException("Element not found!", e);
		}
		
		return libraryEntity;
	}
	
	@Override
	public List<LibraryEntity> getAllLibraries() throws ElementNotFoundException{
		List<LibraryEntity> libraryEntityList;
		
		try {
			TypedQuery<LibraryEntity> query = this.entityManager.createQuery("SELECT l from Library l", LibraryEntity.class);
			libraryEntityList = query.getResultList();
		} catch (RuntimeException e) {
			throw new ElementNotFoundException("Element not found!", e);
		}
		
		return libraryEntityList;
	}
	
	@Override
	public void createLibrary(LibraryEntity libraryEntity) throws PersistenceException{
		
		try {
			this.entityManager.persist(libraryEntity);
		} catch (RuntimeException e) {
			throw new PersistenceException("Create has failed!", e);
		}
	}
	
	@Override
	public void updateLibrary(LibraryEntity libraryEntity) throws PersistenceException{
		
		try {
			this.entityManager.merge(libraryEntity);
		} catch (RuntimeException e) {
			throw new PersistenceException("Update has failed!", e);
		}
	}
	
	@Override
	public void deleteLibrary(LibraryEntity libraryEntity) throws PersistenceException{
		
		try {
			this.entityManager.remove(libraryEntity);
		} catch (RuntimeException e) {
			throw new PersistenceException("Delete has failed!");
		}
	}
}
