package hu.simplesoft.springtutorial.Biblioteca.data.mapper;

import org.mapstruct.Mapper;

import hu.simplesoft.springtutorial.Biblioteca.data.entity.AuthorEntity;
import hu.simplesoft.sprintutorial.Biblioteca.service.dto.AuthorDto;

@Mapper
public abstract class AuthorMapper {

	public abstract AuthorEntity mapAuthorDtoToEntity(AuthorDto authorDto);
	public abstract AuthorDto mapAuthorEntityToDto(AuthorEntity authorEntity);
}
