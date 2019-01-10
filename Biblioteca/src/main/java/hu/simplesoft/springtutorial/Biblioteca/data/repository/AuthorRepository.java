package hu.simplesoft.springtutorial.Biblioteca.data.repository;

import java.util.List;

import hu.simplesoft.springtutorial.Biblioteca.data.entity.AuthorEntity;
import hu.simplesoft.springtutorial.Biblioteca.data.exception.ElementNotFoundException;
import hu.simplesoft.springtutorial.Biblioteca.data.exception.PersistenceException;

public interface AuthorRepository {

	void createAuthor(AuthorEntity authorEntity) throws PersistenceException;
	void updateAuthor(AuthorEntity authorEntity) throws PersistenceException;
	void deleteAuthor(AuthorEntity authorEntity) throws PersistenceException;
	AuthorEntity getAuthorById(long authorId) throws ElementNotFoundException;
	List<AuthorEntity> getAllAuthors() throws ElementNotFoundException;
	
}
