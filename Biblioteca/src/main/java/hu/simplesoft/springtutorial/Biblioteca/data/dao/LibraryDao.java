package hu.simplesoft.springtutorial.Biblioteca.data.dao;

import hu.simplesoft.sprintutorial.Biblioteca.service.dto.LibraryDto;

public interface LibraryDao {

	boolean createLibrary(LibraryDto libraryDto);
	boolean updateLibrary(LibraryDto libraryDto);
	boolean deleteLibrary(long libraryId);
	LibraryDto getLibraryById(long libraryId);
}
