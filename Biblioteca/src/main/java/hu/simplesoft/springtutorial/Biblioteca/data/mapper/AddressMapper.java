package hu.simplesoft.springtutorial.Biblioteca.data.mapper;

import org.mapstruct.Mapper;

import hu.simplesoft.springtutorial.Biblioteca.data.entity.AddressEntity;
import hu.simplesoft.sprintutorial.Biblioteca.service.dto.AddressDto;

@Mapper
public abstract class AddressMapper {

	public abstract AddressEntity mapAddressDtoToEntity(AddressDto addressDto);
	public abstract AddressDto mapAddressEntityToDto(AddressEntity addressEntity);
}
