package hu.simplesoft.springtutorial.Biblioteca.service;

import java.util.List;

import hu.simplesoft.springtutorial.Biblioteca.service.exception.ServiceException;
import hu.simplesoft.sprintutorial.Biblioteca.service.dto.AuthorDto;

public interface AuthorService {

	void createAuthor(AuthorDto authorDto) throws ServiceException;
	void updateAuthor(AuthorDto authorDto) throws ServiceException;
	void deleteAuthor(long authorId) throws ServiceException;
	AuthorDto getAuthorById(long authorId) throws ServiceException;
	List<AuthorDto> getAllAuthors() throws ServiceException;
}
