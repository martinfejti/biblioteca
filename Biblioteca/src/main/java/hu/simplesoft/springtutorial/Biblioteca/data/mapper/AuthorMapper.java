package hu.simplesoft.springtutorial.Biblioteca.data.mapper;


import java.util.ArrayList;
import java.util.List;

import hu.simplesoft.springtutorial.Biblioteca.data.entity.AuthorEntity;
import hu.simplesoft.sprintutorial.Biblioteca.service.dto.AuthorDto;

public final class AuthorMapper {

	private AuthorMapper() {
		
	}
	
	public static AuthorEntity convertDtoToEntity(AuthorDto authorDto) {
		AuthorEntity authorEntity = new AuthorEntity();
		
		authorEntity.setAuthorId(authorDto.getId());
		authorEntity.setName(authorDto.getName());
		authorEntity.setBirthDate(authorDto.getBirthDate());
		authorEntity.setBirthPlace(authorDto.getBirthPlace());
		authorEntity.setNationality(authorDto.getNationality());
		
		return authorEntity;
	}
	
	public static AuthorDto convertEntityToDto(AuthorEntity authorEntity) {
		AuthorDto authorDto = new AuthorDto();
		
		authorDto.setId(authorEntity.getAuthorId());
		authorDto.setName(authorEntity.getName());
		authorDto.setBirthDate(authorEntity.getBirthDate());
		authorDto.setBirthPlace(authorEntity.getBirthPlace());
		authorDto.setNationality(authorEntity.getNationality());
		
		return authorDto;
	}
	
	public static List<AuthorDto> convertListEntityToDto(List<AuthorEntity> authorEntityList){
		List<AuthorDto> listAuthorDto = new ArrayList<>();
		
		for(AuthorEntity authorEntity : authorEntityList) {
			listAuthorDto.add(convertEntityToDto(authorEntity));
		}
		
		return listAuthorDto;
	}
}
