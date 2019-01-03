package hu.simplesoft.springtutorial.Biblioteca.data.mapper;

import org.mapstruct.Mapper;

import hu.simplesoft.springtutorial.Biblioteca.data.entity.BookEntity;
import hu.simplesoft.sprintutorial.Biblioteca.service.dto.BookDto;

@Mapper
public abstract class BookMapper {

	public abstract BookEntity mapBookDtoToEntity(BookDto bookDto);
	public abstract BookDto mapBookEntityToDto(BookEntity bookEntity);
}
