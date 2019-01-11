package hu.simplesoft.springtutorial.Biblioteca.data.dao;

import java.util.List;

import hu.simplesoft.springtutorial.Biblioteca.data.exception.ElementNotFoundException;
import hu.simplesoft.springtutorial.Biblioteca.data.exception.ObjectIsNullException;
import hu.simplesoft.springtutorial.Biblioteca.data.exception.PersistenceException;
import hu.simplesoft.sprintutorial.Biblioteca.service.dto.LibraryDto;

public interface LibraryDao {

	void createLibrary(LibraryDto libraryDto) throws PersistenceException;
	void updateLibrary(LibraryDto libraryDto) throws PersistenceException, ObjectIsNullException;
	void deleteLibrary(long libraryId) throws PersistenceException, ObjectIsNullException;
	LibraryDto getLibraryById(long libraryId) throws ElementNotFoundException, ObjectIsNullException;
	List<LibraryDto> getAllLibraries() throws ElementNotFoundException;
}
