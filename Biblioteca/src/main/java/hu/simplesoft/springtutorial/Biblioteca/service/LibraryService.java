package hu.simplesoft.springtutorial.Biblioteca.service;

import java.util.List;

import hu.simplesoft.springtutorial.Biblioteca.service.exception.ServiceException;
import hu.simplesoft.sprintutorial.Biblioteca.service.dto.LibraryDto;

public interface LibraryService {

	void createLibrary(LibraryDto libraryDto) throws ServiceException;
	void updateLibrary(LibraryDto libraryDto) throws ServiceException;
	void deleteLibrary(long libraryId) throws ServiceException;
	LibraryDto getLibraryById(long libraryId) throws ServiceException;
	List<LibraryDto> getAllLibraries() throws ServiceException;
}
