package hu.simplesoft.springtutorial.Biblioteca.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.simplesoft.springtutorial.Biblioteca.data.dao.AuthorDao;
import hu.simplesoft.springtutorial.Biblioteca.data.exception.PersistenceException;
import hu.simplesoft.springtutorial.Biblioteca.service.AuthorService;
import hu.simplesoft.springtutorial.Biblioteca.service.exception.ServiceException;
import hu.simplesoft.sprintutorial.Biblioteca.service.dto.AuthorDto;

@Service
public class AuthorServiceImpl implements AuthorService{

	@Autowired
	private AuthorDao authorDao;
	
	@Override
	public void createAuthor(AuthorDto authorDto) throws ServiceException{
		try {
			this.authorDao.createAuthor(authorDto);
		} catch (PersistenceException e) {
			throw new ServiceException("Create has failed!", e);
		}
	}
	
	@Override
	public void updateAuthor(AuthorDto authorDto) throws ServiceException{
		try {
			this.authorDao.updateAuthor(authorDto);
		} catch (PersistenceException e) {
			throw new ServiceException("Update has failed!",e );
		}
	}
	
	@Override
	public void deleteAuthor(long authorId) throws ServiceException{
		try {
			this.authorDao.deleteAuthor(authorId);
		} catch (PersistenceException e) {
			throw new ServiceException("Delete has failed!");
		}
	}
	
	@Override
	public AuthorDto getAuthorById(long authorId) throws ServiceException{
		try {
			return this.authorDao.getAuthorById(authorId);
		} catch (PersistenceException e) {
			throw new ServiceException("Element not found!", e);
		}
	}
	
	@Override
	public List<AuthorDto> getAllAuthors() throws ServiceException{
		try {
			return this.authorDao.getAllAuthors();
		} catch (PersistenceException e) {
			throw new ServiceException("Element not found!");
		}
	}
}
