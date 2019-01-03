package hu.simplesoft.springtutorial.Biblioteca.data.mapper;

import org.mapstruct.Mapper;

import hu.simplesoft.springtutorial.Biblioteca.data.entity.LibraryEntity;
import hu.simplesoft.sprintutorial.Biblioteca.service.dto.LibraryDto;

@Mapper
public abstract class LibraryMapper {

	public abstract LibraryEntity mapLibraryDtoToEntity(LibraryDto libraryDto);
	public abstract LibraryDto mapLibraryEntityToDto(LibraryEntity libraryEntity);
}
