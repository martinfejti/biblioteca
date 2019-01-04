package hu.simplesoft.springtutorial.Biblioteca.data.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Repository;

import hu.simplesoft.springtutorial.Biblioteca.data.dao.AuthorDao;
import hu.simplesoft.springtutorial.Biblioteca.data.entity.AuthorEntity;
import hu.simplesoft.springtutorial.Biblioteca.data.mapper.AuthorMapper;
import hu.simplesoft.springtutorial.Biblioteca.data.util.Constants;
import hu.simplesoft.sprintutorial.Biblioteca.service.dto.AuthorDto;

@Repository
@Transactional
public class AuthorDaoImpl implements AuthorDao {

	private static final Logger LOGGER = LogManager.getLogger(AuthorDaoImpl.class);
	private static final AuthorMapper AUTHOR_MAPPER = Mappers.getMapper(AuthorMapper.class);
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public AuthorDaoImpl() {
		
	}
	
	@Override
	public AuthorDto getAuthorByName(String name) {
		AuthorEntity foundEntity = entityManager.find(AuthorEntity.class, name);
		
		return AUTHOR_MAPPER.mapAuthorEntityToDto(foundEntity);
	}
	
	@Override
	public boolean createAuthor(AuthorDto authorDto) {
		boolean isSuccess = false;
		AuthorEntity newAuthorEntity = AUTHOR_MAPPER.mapAuthorDtoToEntity(authorDto);
		
		try {
			this.entityManager.persist(newAuthorEntity);
			isSuccess = true;
		} catch (RuntimeException e) {
			LOGGER.error(Constants.AuthorDaoErrorMessages.CREATE_FAILED,e);
		}
		return isSuccess;
	}
	
	@Override
	public boolean updateAuthor(AuthorDto authorDto) {
		boolean isSuccess = false;
		AuthorEntity newAuthorEntityForUpdate = entityManager.find(AuthorEntity.class, authorDto.getId());
		
		if(newAuthorEntityForUpdate != null) {
			newAuthorEntityForUpdate = updateAuthorEntity(newAuthorEntityForUpdate, authorDto);
			
			try {
				this.entityManager.merge(newAuthorEntityForUpdate);
				isSuccess = true;
			} catch (RuntimeException e) {
				LOGGER.error(Constants.AuthorDaoErrorMessages.UPDATE_FAILED, e);
			}
		}
		return isSuccess;
	}
	
	@Override
	public boolean deleteAuthor(long authorId) {
		boolean isSuccess = false;
		AuthorEntity authorEntityForDelete = entityManager.find(AuthorEntity.class, authorId);
		
		try {
			this.entityManager.remove(authorEntityForDelete);
			isSuccess = true;
		} catch (RuntimeException e) {
			LOGGER.error(Constants.AuthorDaoErrorMessages.DELETE_FAILED);
		}
		
		return isSuccess;
	}
	
	private AuthorEntity updateAuthorEntity(AuthorEntity originalAuthorEntity, AuthorDto newAuthorDto) {
		
		AuthorEntity newAuthorEntity = AUTHOR_MAPPER.mapAuthorDtoToEntity(newAuthorDto);
		
		originalAuthorEntity.setAuthorId(newAuthorEntity.getAuthorId());
		originalAuthorEntity.setName(newAuthorEntity.getName());
		originalAuthorEntity.setBirthDate(newAuthorEntity.getBirthDate());
		originalAuthorEntity.setBirthPlace(newAuthorEntity.getBirthPlace());
		originalAuthorEntity.setNationality(newAuthorEntity.getNationality());
		
		return originalAuthorEntity;
	}
}
