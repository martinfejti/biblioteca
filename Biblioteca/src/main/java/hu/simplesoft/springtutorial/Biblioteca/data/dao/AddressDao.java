package hu.simplesoft.springtutorial.Biblioteca.data.dao;

import hu.simplesoft.sprintutorial.Biblioteca.service.dto.AddressDto;

public interface AddressDao {

	boolean createAddress(AddressDto addressDto);
	boolean updateAddress(AddressDto addressDto);
	boolean deleteAddress(long addressId);
	AddressDto getAddressById(long addressId);
}
