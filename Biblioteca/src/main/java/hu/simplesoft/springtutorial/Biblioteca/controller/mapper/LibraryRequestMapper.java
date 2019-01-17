package hu.simplesoft.springtutorial.Biblioteca.controller.mapper;

import hu.simplesoft.springtutorial.Biblioteca.controller.request.LibraryCreateRequest;
import hu.simplesoft.springtutorial.Biblioteca.controller.request.LibraryUpdateRequest;
import hu.simplesoft.sprintutorial.Biblioteca.service.dto.AddressDto;
import hu.simplesoft.sprintutorial.Biblioteca.service.dto.LibraryDto;

public class LibraryRequestMapper {

	private LibraryRequestMapper() {
	}
	
	public static LibraryDto convertCreateRequestToDto(LibraryCreateRequest libraryCreateRequest){
		LibraryDto libraryDto = new LibraryDto();
		AddressDto addressDto = new AddressDto();
		
		libraryDto.setName(libraryCreateRequest.getName());
		libraryDto.setAddress(addressDto);
		
		return libraryDto;
	}
	
	public static LibraryDto convertUpdateRequestToDto(LibraryUpdateRequest libraryUpdateRequest) {
		LibraryDto libraryDto = new LibraryDto();
		AddressDto addressDto = new AddressDto();
		
		libraryDto.setId(libraryUpdateRequest.getId());
		libraryDto.setName(libraryUpdateRequest.getName());
		libraryDto.setAddress(addressDto);
		
		return libraryDto;
	}
}
