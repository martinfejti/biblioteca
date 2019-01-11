package hu.simplesoft.springtutorial.Biblioteca.data.dao.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hu.simplesoft.springtutorial.Biblioteca.data.dao.LibraryDao;
import hu.simplesoft.springtutorial.Biblioteca.data.entity.LibraryEntity;
import hu.simplesoft.springtutorial.Biblioteca.data.exception.ElementNotFoundException;
import hu.simplesoft.springtutorial.Biblioteca.data.exception.ObjectIsNullException;
import hu.simplesoft.springtutorial.Biblioteca.data.exception.PersistenceException;
import hu.simplesoft.springtutorial.Biblioteca.data.mapper.LibraryMapper;
import hu.simplesoft.springtutorial.Biblioteca.data.repository.LibraryRepository;
import hu.simplesoft.springtutorial.Biblioteca.data.util.Validator;
import hu.simplesoft.sprintutorial.Biblioteca.service.dto.LibraryDto;

@Component
public class LibraryDaoImpl implements LibraryDao{

	@Autowired
	private LibraryRepository libraryRepository;
	
	public LibraryDaoImpl() {
	}
	
	@Override
	public LibraryDto getLibraryById(long libraryId) throws ElementNotFoundException, ObjectIsNullException{
		LibraryEntity libraryEntity = this.libraryRepository.getLibraryById(libraryId);
		
		Validator.validateObject(libraryEntity, libraryId);
		
		return LibraryMapper.convertEntityToDto(libraryEntity);
	}
	
	@Override
	public List<LibraryDto> getAllLibraries() throws ElementNotFoundException{
		List<LibraryEntity> libraryEntityList = this.libraryRepository.getAllLibraries();
		
		return LibraryMapper.convertListEntityToDto(libraryEntityList);
	}
	
	@Override
	public void createLibrary(LibraryDto libraryDto) throws PersistenceException{
		LibraryEntity newLibraryEntity = LibraryMapper.convertDtoToEntity(libraryDto);

		this.libraryRepository.createLibrary(newLibraryEntity);
	}
	
	@Override
	public void updateLibrary(LibraryDto libraryDto) throws PersistenceException, ObjectIsNullException{
		LibraryEntity libraryEntityForUpdate = this.libraryRepository.getLibraryById(libraryDto.getId());
		
		Validator.validateObject(libraryEntityForUpdate, libraryDto.getId());
		
		libraryEntityForUpdate = updateLibraryEntity(libraryEntityForUpdate, libraryDto);
		
		this.libraryRepository.updateLibrary(libraryEntityForUpdate);
	}
	
	@Override
	public void deleteLibrary(long libraryId) throws PersistenceException, ObjectIsNullException{
		LibraryEntity libraryEntityForDelete = this.libraryRepository.getLibraryById(libraryId);
		
		Validator.validateObject(libraryEntityForDelete, libraryId);
		
		this.libraryRepository.deleteLibrary(libraryEntityForDelete);
	}
	
	public LibraryEntity updateLibraryEntity(LibraryEntity originalLibraryEntity, LibraryDto newLibraryDto) {
		LibraryEntity newLibraryEntity = LibraryMapper.convertDtoToEntity(newLibraryDto);
		
		originalLibraryEntity.setLibraryId(newLibraryEntity.getLibraryId());
		originalLibraryEntity.setName(newLibraryEntity.getName());
		originalLibraryEntity.setAddress(newLibraryEntity.getAddress());
		
		return originalLibraryEntity;
	}
}
