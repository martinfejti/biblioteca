package hu.simplesoft.springtutorial.Biblioteca.data.mapper;


import java.util.ArrayList;
import java.util.List;

import hu.simplesoft.springtutorial.Biblioteca.data.entity.BookEntity;
import hu.simplesoft.sprintutorial.Biblioteca.service.dto.BookDto;

public final class BookMapper {

	private BookMapper() {
		
	}
	
	public static BookEntity convertDtoToEntity(BookDto bookDto) {
		BookEntity bookEntity = new BookEntity();
		
		bookEntity.setBookId(bookDto.getId());
		bookEntity.setTitle(bookDto.getTitle());
		bookEntity.setAuthor(AuthorMapper.convertDtoToEntity(bookDto.getAuthor()));
		bookEntity.setPublishYear(bookDto.getPublishYear());
		bookEntity.setCategory(bookDto.getCategory());
		bookEntity.setLibrary(LibraryMapper.convertDtoToEntity(bookDto.getLibrary()));
		
		return bookEntity;
	}
	
	public static BookDto convertEntityToDto(BookEntity bookEntity) {
		BookDto bookDto = new BookDto();
		
		bookDto.setId(bookEntity.getBookId());
		bookDto.setTitle(bookEntity.getTitle());
		bookDto.setAuthor(AuthorMapper.convertEntityToDto(bookEntity.getAuthor()));
		bookDto.setPublishYear(bookEntity.getPublishYear());
		bookDto.setCategory(bookEntity.getCategory());
		bookDto.setLibrary(LibraryMapper.convertEntityToDto(bookEntity.getLibrary()));
		
		return bookDto;
		
	}
	
	public static List<BookDto> convertListEntityToDto(List<BookEntity> bookEntityList){
		List<BookDto> bookDtoList = new ArrayList<>();
		
		for(BookEntity bookEntity : bookEntityList) {
			bookDtoList.add(convertEntityToDto(bookEntity));
		}
		
		return bookDtoList;
	}
}
