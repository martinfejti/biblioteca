package hu.simplesoft.springtutorial.Biblioteca.data.dao;

import hu.simplesoft.sprintutorial.Biblioteca.service.dto.AuthorDto;

public interface AuthorDao {

	boolean createAuthor(AuthorDto authorDto);
	boolean updateAuthor(AuthorDto authorDto);
	boolean deleteAuthor(long auhtorId);
	AuthorDto getAuthorByName(String name);
}
