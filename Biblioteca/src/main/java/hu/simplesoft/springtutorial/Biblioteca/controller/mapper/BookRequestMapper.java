package hu.simplesoft.springtutorial.Biblioteca.controller.mapper;

import hu.simplesoft.springtutorial.Biblioteca.controller.request.BookCreateRequest;
import hu.simplesoft.springtutorial.Biblioteca.controller.request.BookUpdateRequest;
import hu.simplesoft.sprintutorial.Biblioteca.service.dto.AuthorDto;
import hu.simplesoft.sprintutorial.Biblioteca.service.dto.BookDto;
import hu.simplesoft.sprintutorial.Biblioteca.service.dto.LibraryDto;

public final class BookRequestMapper {

	private BookRequestMapper() {
	}
	
	public static BookDto convertCreateRequestToDto(BookCreateRequest bookCreateRequest) {
		BookDto bookDto = new BookDto();
		AuthorDto authorDto = new AuthorDto();
		LibraryDto libraryDto = new LibraryDto();
		
		bookDto.setTitle(bookCreateRequest.getName());
		bookDto.setAuthor(authorDto);
		bookDto.setPublishYear(bookCreateRequest.getPublishYear());
		bookDto.setCategory(bookCreateRequest.getCategory());
		bookDto.setLibrary(libraryDto);
		
		return bookDto;
	}
	
	public static BookDto convertUpdateRequestToDto(BookUpdateRequest bookUpdateRequest) {
		BookDto bookDto = new BookDto();
		AuthorDto authorDto = new AuthorDto();
		LibraryDto libraryDto = new LibraryDto();
		
		bookDto.setId(bookUpdateRequest.getId());
		bookDto.setTitle(bookUpdateRequest.getName());
		bookDto.setAuthor(authorDto);
		bookDto.setPublishYear(bookUpdateRequest.getPublishYear());
		bookDto.setCategory(bookUpdateRequest.getCategory());
		bookDto.setLibrary(libraryDto);
		
		return bookDto;
	}
}
