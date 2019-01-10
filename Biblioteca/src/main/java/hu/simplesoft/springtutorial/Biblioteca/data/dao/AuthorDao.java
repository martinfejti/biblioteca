package hu.simplesoft.springtutorial.Biblioteca.data.dao;

import java.util.List;

import hu.simplesoft.springtutorial.Biblioteca.data.exception.ElementNotFoundException;
import hu.simplesoft.springtutorial.Biblioteca.data.exception.PersistenceException;
import hu.simplesoft.sprintutorial.Biblioteca.service.dto.AuthorDto;

public interface AuthorDao {

	void createAuthor(AuthorDto authorDto) throws PersistenceException;
	void updateAuthor(AuthorDto authorDto) throws PersistenceException;
	void deleteAuthor(long auhtorId) throws PersistenceException;
	AuthorDto getAuthorById(long authorId) throws ElementNotFoundException;
	List<AuthorDto> getAllAuthors() throws ElementNotFoundException;
}
