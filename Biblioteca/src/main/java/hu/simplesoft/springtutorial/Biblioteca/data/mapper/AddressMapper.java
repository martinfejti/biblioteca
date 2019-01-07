package hu.simplesoft.springtutorial.Biblioteca.data.mapper;


import java.util.ArrayList;
import java.util.List;

import hu.simplesoft.springtutorial.Biblioteca.data.entity.AddressEntity;
import hu.simplesoft.sprintutorial.Biblioteca.service.dto.AddressDto;

public final class AddressMapper {

	private AddressMapper() {
		
	}
	
	public static AddressEntity convertDtoToEntity(AddressDto addressDto) {
		AddressEntity addressEntity = new AddressEntity();
		
		addressEntity.setAddressId(addressDto.getId());
		addressEntity.setCountry(addressDto.getCountry());
		addressEntity.setCity(addressDto.getCity());
		addressEntity.setStreet(addressDto.getStreet());
		addressEntity.setHouse_number(addressDto.getHouseNumber());
		
		return addressEntity;
	}
	
	public static AddressDto convertEntityToDto(AddressEntity addressEntity) {
		AddressDto addressDto = new AddressDto();
		
		addressDto.setId(addressEntity.getAddressId());
		addressDto.setCountry(addressEntity.getCountry());
		addressDto.setCity(addressEntity.getCity());
		addressDto.setStreet(addressEntity.getStreet());
		addressDto.setHouseNumber(addressEntity.getHouseNumber());
		
		return addressDto;
	}
	
	public static List<AddressDto> convertListEntityToDto(List<AddressEntity> addressEntityList){
		List<AddressDto> addressDtoList = new ArrayList<>();
		
		for(AddressEntity addressEntity : addressEntityList) {
			addressDtoList.add(convertEntityToDto(addressEntity));
		}
		
		return addressDtoList;
	}
}
