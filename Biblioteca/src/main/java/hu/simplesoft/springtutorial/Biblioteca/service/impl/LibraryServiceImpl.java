package hu.simplesoft.springtutorial.Biblioteca.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.simplesoft.springtutorial.Biblioteca.data.dao.LibraryDao;
import hu.simplesoft.springtutorial.Biblioteca.data.exception.PersistenceException;
import hu.simplesoft.springtutorial.Biblioteca.service.LibraryService;
import hu.simplesoft.springtutorial.Biblioteca.service.exception.ServiceException;
import hu.simplesoft.sprintutorial.Biblioteca.service.dto.LibraryDto;

@Service
public class LibraryServiceImpl implements LibraryService{

	@Autowired
	private LibraryDao libraryDao;
	
	@Override
	public void createLibrary(LibraryDto libraryDto) throws ServiceException{
		try {
			this.libraryDao.createLibrary(libraryDto);
		} catch (PersistenceException e) {
			throw new ServiceException("Create has failed!", e);
		}
	}
	
	@Override
	public void updateLibrary(LibraryDto libraryDto) throws ServiceException{
		try {
			this.libraryDao.updateLibrary(libraryDto);
		} catch (PersistenceException e) {
			throw new ServiceException("Update has failed!", e);
		}
	}
	
	@Override
	public void deleteLibrary(long libraryId) throws ServiceException{
		try {
			this.libraryDao.deleteLibrary(libraryId);
		} catch (PersistenceException e) {
			throw new ServiceException("Delete has failed!", e);
		}
	}
	
	@Override
	public LibraryDto getLibraryById(long libraryId) throws ServiceException{
		try {
			return this.libraryDao.getLibraryById(libraryId);
		} catch (PersistenceException e) {
			throw new ServiceException("Element not found!", e);
		}
	}
	
	@Override
	public List<LibraryDto> getAllLibraries() throws ServiceException{
		try {
			return this.libraryDao.getAllLibraries();
		} catch (PersistenceException e) {
			throw new ServiceException("Element not found!", e);
		}
	}
}
