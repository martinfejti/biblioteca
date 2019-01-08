package hu.simplesoft.springtutorial.Biblioteca.data.dao;

import java.util.List;

import hu.simplesoft.springtutorial.Biblioteca.data.exception.ElementNotFoundException;
import hu.simplesoft.springtutorial.Biblioteca.data.exception.PersistenceException;
import hu.simplesoft.sprintutorial.Biblioteca.service.dto.AddressDto;

public interface AddressDao {

	void createAddress(AddressDto addressDto) throws PersistenceException;
	void updateAddress(AddressDto addressDto) throws PersistenceException;
	void deleteAddress(long addressId) throws PersistenceException;
	AddressDto getAddressById(long addressId) throws ElementNotFoundException;
	List<AddressDto> getAllAddresses() throws ElementNotFoundException;
}
