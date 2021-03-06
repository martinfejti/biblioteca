package hu.simplesoft.springtutorial.Biblioteca.data.mapper;


import java.util.ArrayList;
import java.util.List;

import hu.simplesoft.springtutorial.Biblioteca.data.entity.LibraryEntity;
import hu.simplesoft.sprintutorial.Biblioteca.service.dto.LibraryDto;

public final class LibraryMapper {

	private LibraryMapper() {
		
	}
	
	public static LibraryEntity convertDtoToEntity(LibraryDto libraryDto) {
		LibraryEntity libraryEntity = new LibraryEntity();
		
		libraryEntity.setLibraryId(libraryDto.getId());
		libraryEntity.setName(libraryDto.getName());
		libraryEntity.setAddress(AddressMapper.convertDtoToEntity(libraryDto.getAddress()));
		
		return libraryEntity;
	}
	
	public static LibraryDto convertEntityToDto(LibraryEntity libraryEntity) {
		LibraryDto libraryDto = new LibraryDto();
		
		libraryDto.setId(libraryEntity.getLibraryId());
		libraryDto.setName(libraryEntity.getName());
		libraryDto.setAddress(AddressMapper.convertEntityToDto(libraryEntity.getAddress()));
		
		return libraryDto;
	}
	
	public static List<LibraryDto> convertListEntityToDto(List<LibraryEntity> libraryEntityList) {
		List<LibraryDto> libraryDtoList = new ArrayList<>();
		
		for(LibraryEntity libraryEntity : libraryEntityList) {
			libraryDtoList.add(convertEntityToDto(libraryEntity));
		}
		
		return libraryDtoList;
	}
}
