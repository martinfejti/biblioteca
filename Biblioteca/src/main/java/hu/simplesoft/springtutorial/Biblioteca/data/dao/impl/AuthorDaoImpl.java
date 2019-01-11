package hu.simplesoft.springtutorial.Biblioteca.data.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import hu.simplesoft.springtutorial.Biblioteca.data.dao.AuthorDao;
import hu.simplesoft.springtutorial.Biblioteca.data.entity.AuthorEntity;
import hu.simplesoft.springtutorial.Biblioteca.data.exception.ElementNotFoundException;
import hu.simplesoft.springtutorial.Biblioteca.data.exception.ObjectIsNullException;
import hu.simplesoft.springtutorial.Biblioteca.data.exception.PersistenceException;
import hu.simplesoft.springtutorial.Biblioteca.data.mapper.AuthorMapper;
import hu.simplesoft.springtutorial.Biblioteca.data.repository.AuthorRepository;
import hu.simplesoft.springtutorial.Biblioteca.data.util.Validator;
import hu.simplesoft.sprintutorial.Biblioteca.service.dto.AuthorDto;

@Component
public class AuthorDaoImpl implements AuthorDao {

	private AuthorRepository authorRepository;
	
	public AuthorDaoImpl() {
		
	}
	
	@Override
	public AuthorDto getAuthorById(long authorId) throws ElementNotFoundException, ObjectIsNullException{
		AuthorEntity foundEntity = this.authorRepository.getAuthorById(authorId);
		
		Validator.validateObject(foundEntity, authorId);
		
		return AuthorMapper.convertEntityToDto(foundEntity);
	}
	
	@Override
	public List<AuthorDto> getAllAuthors() throws ElementNotFoundException{
		List<AuthorEntity> authorEntityList = this.authorRepository.getAllAuthors();
		
		return AuthorMapper.convertListEntityToDto(authorEntityList);
	}
	
	@Override
	public void createAuthor(AuthorDto authorDto) throws PersistenceException{
		AuthorEntity newAuthorEntity = AuthorMapper.convertDtoToEntity(authorDto);
		
		this.authorRepository.createAuthor(newAuthorEntity);
	}
	
	@Override
	public void updateAuthor(AuthorDto authorDto) throws PersistenceException, ObjectIsNullException{
		AuthorEntity newAuthorEntityForUpdate = this.authorRepository.getAuthorById(authorDto.getId());
		
		Validator.validateObject(newAuthorEntityForUpdate, authorDto.getId());
		
		if(newAuthorEntityForUpdate != null) {
			newAuthorEntityForUpdate = updateAuthorEntity(newAuthorEntityForUpdate, authorDto);
			
			this.authorRepository.updateAuthor(newAuthorEntityForUpdate);
		}
	}
	
	@Override
	public void deleteAuthor(long authorId) throws PersistenceException, ObjectIsNullException{
		AuthorEntity authorEntityForDelete = this.authorRepository.getAuthorById(authorId);
		
		Validator.validateObject(authorEntityForDelete, authorId);
		
		this.authorRepository.deleteAuthor(authorEntityForDelete);
	}
	
	private AuthorEntity updateAuthorEntity(AuthorEntity originalAuthorEntity, AuthorDto newAuthorDto) {
		
		AuthorEntity newAuthorEntity = AuthorMapper.convertDtoToEntity(newAuthorDto);
		
		originalAuthorEntity.setAuthorId(newAuthorEntity.getAuthorId());
		originalAuthorEntity.setName(newAuthorEntity.getName());
		originalAuthorEntity.setBirthDate(newAuthorEntity.getBirthDate());
		originalAuthorEntity.setBirthPlace(newAuthorEntity.getBirthPlace());
		originalAuthorEntity.setNationality(newAuthorEntity.getNationality());
		
		return originalAuthorEntity;
	}
}
