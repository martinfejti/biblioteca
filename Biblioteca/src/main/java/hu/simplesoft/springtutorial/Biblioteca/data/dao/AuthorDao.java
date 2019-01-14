package hu.simplesoft.springtutorial.Biblioteca.data.dao;

import java.util.List;

import hu.simplesoft.springtutorial.Biblioteca.data.exception.ObjectIsNullException;
import hu.simplesoft.springtutorial.Biblioteca.data.exception.PersistenceException;
import hu.simplesoft.sprintutorial.Biblioteca.service.dto.AuthorDto;

public interface AuthorDao {

	void createAuthor(AuthorDto authorDto) throws PersistenceException;
	void updateAuthor(AuthorDto authorDto) throws PersistenceException, ObjectIsNullException;
	void deleteAuthor(long auhtorId) throws PersistenceException, ObjectIsNullException;
	AuthorDto getAuthorById(long authorId) throws PersistenceException, ObjectIsNullException;
	List<AuthorDto> getAllAuthors() throws PersistenceException;
}
