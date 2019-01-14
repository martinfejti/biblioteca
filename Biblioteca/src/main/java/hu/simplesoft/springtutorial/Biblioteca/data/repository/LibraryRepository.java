package hu.simplesoft.springtutorial.Biblioteca.data.repository;

import java.util.List;

import hu.simplesoft.springtutorial.Biblioteca.data.entity.LibraryEntity;
import hu.simplesoft.springtutorial.Biblioteca.data.exception.PersistenceException;

public interface LibraryRepository {

	void createLibrary(LibraryEntity libraryEntity) throws PersistenceException;
	void updateLibrary(LibraryEntity libraryEntity) throws PersistenceException;
	void deleteLibrary(LibraryEntity libraryEntity) throws PersistenceException;
	LibraryEntity getLibraryById(long libraryId) throws PersistenceException;
	List<LibraryEntity> getAllLibraries() throws PersistenceException;
	
}
