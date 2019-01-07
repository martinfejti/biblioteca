package hu.simplesoft.springtutorial.Biblioteca.data.dao.impl;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import hu.simplesoft.springtutorial.Biblioteca.data.dao.LibraryDao;
import hu.simplesoft.springtutorial.Biblioteca.data.entity.LibraryEntity;
import hu.simplesoft.springtutorial.Biblioteca.data.mapper.LibraryMapper;
import hu.simplesoft.sprintutorial.Biblioteca.service.dto.LibraryDto;

@Repository
@Transactional
public class LibraryDaoImpl implements LibraryDao{

	@PersistenceContext
	private EntityManager entityManager;
	
	public LibraryDaoImpl() {
		
	}
	
	@Override
	public LibraryDto getLibraryById(long libraryId) {
		LibraryEntity libraryEntity = entityManager.find(LibraryEntity.class, libraryId);
		
		return LibraryMapper.convertEntityToDto(libraryEntity);
	}
	
	@Override
	public boolean createLibrary(LibraryDto libraryDto) {
		boolean isSuccess = false;
		LibraryEntity newLibraryEntity = LibraryMapper.convertDtoToEntity(libraryDto);
		
		try {
			this.entityManager.persist(newLibraryEntity);
			isSuccess = true;
		} catch(RuntimeException e) {
		}
		
		return isSuccess;
	}
	
	@Override
	public boolean updateLibrary(LibraryDto libraryDto) {
		boolean isSuccess = false;
		LibraryEntity libraryEntityForUpdate = entityManager.find(LibraryEntity.class, libraryDto.getId());
		
		if(libraryEntityForUpdate != null) {
			libraryEntityForUpdate = updateLibraryEntity(libraryEntityForUpdate, libraryDto);
			
			try {
				this.entityManager.merge(libraryEntityForUpdate);
				isSuccess = true;
			} catch (RuntimeException e) {
			}
		}
		
		return isSuccess;
	}
	
	@Override
	public boolean deleteLibrary(long libraryId) {
		boolean isSuccess = false;
		LibraryEntity libraryEntityForDelete = entityManager.find(LibraryEntity.class, libraryId);
		
		try {
			this.entityManager.remove(libraryEntityForDelete);
			isSuccess = true;
		} catch (RuntimeException e) {
		}
		
		return isSuccess;
	}
	
	public LibraryEntity updateLibraryEntity(LibraryEntity originalLibraryEntity, LibraryDto newLibraryDto) {
		LibraryEntity newLibraryEntity = LibraryMapper.convertDtoToEntity(newLibraryDto);
		
		originalLibraryEntity.setLibraryId(newLibraryEntity.getLibraryId());
		originalLibraryEntity.setName(newLibraryEntity.getName());
		originalLibraryEntity.setAddress(newLibraryEntity.getAddress());
		
		return originalLibraryEntity;
	}
}
