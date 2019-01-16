package hu.simplesoft.springtutorial.Biblioteca.controller.request.mapper;

import hu.simplesoft.springtutorial.Biblioteca.controller.request.AddressCreateRequest;
import hu.simplesoft.springtutorial.Biblioteca.controller.request.AddressUpdateRequest;
import hu.simplesoft.sprintutorial.Biblioteca.service.dto.AddressDto;

public final class AddressRequestMapper {

	private AddressRequestMapper() {
	}
	
	public static AddressDto convertCreateRequestToDto(AddressCreateRequest addressCreateRequest) {
		AddressDto addressDto = new AddressDto();
		
		addressDto.setCountry(addressCreateRequest.getCountry());
		addressDto.setCity(addressCreateRequest.getCity());
		addressDto.setStreet(addressCreateRequest.getStreet());
		addressDto.setHouseNumber(addressCreateRequest.getHouseNumber());
		
		return addressDto;
	}
	
	public static AddressDto convertUpdateRequestToDto(AddressUpdateRequest addressUpdateRequest) {
		AddressDto addressDto = new AddressDto();
		
		addressDto.setId(addressUpdateRequest.getId());
		addressDto.setCountry(addressUpdateRequest.getCountry());
		addressDto.setCity(addressUpdateRequest.getCity());
		addressDto.setStreet(addressUpdateRequest.getStreet());
		addressDto.setHouseNumber(addressUpdateRequest.getHouseNumber());
		
		return addressDto;
	}
}
