package hu.simplesoft.springtutorial.Biblioteca.controller.mapper;

import hu.simplesoft.springtutorial.Biblioteca.controller.request.AuthorCreateRequest;
import hu.simplesoft.springtutorial.Biblioteca.controller.request.AuthorUpdateRequest;
import hu.simplesoft.sprintutorial.Biblioteca.service.dto.AuthorDto;

public final class AuthorRequestMapper {

	private AuthorRequestMapper() {
	}
	
	public static AuthorDto convertCreateRequestToDto(AuthorCreateRequest authorCreateRequest) {
		AuthorDto authorDtoToConvert = new AuthorDto();
		
		authorDtoToConvert.setName(authorCreateRequest.getName());
		authorDtoToConvert.setBirthDate(authorCreateRequest.getBirthdate());
		authorDtoToConvert.setBirthPlace(authorCreateRequest.getBirthplace());
		authorDtoToConvert.setNationality(authorCreateRequest.getNationality());
		
		return authorDtoToConvert;
	}
	
	public static AuthorDto convertUpdateRequestToDto(AuthorUpdateRequest authorUpdateRequest) {
		AuthorDto authorDtoToConvert = new AuthorDto();
		
		authorDtoToConvert.setId(authorUpdateRequest.getId());
		authorDtoToConvert.setName(authorUpdateRequest.getName());
		authorDtoToConvert.setBirthDate(authorUpdateRequest.getBirthdate());
		authorDtoToConvert.setBirthPlace(authorUpdateRequest.getBirthplace());
		authorDtoToConvert.setNationality(authorUpdateRequest.getNationality());
		
		return authorDtoToConvert;
	}
}
