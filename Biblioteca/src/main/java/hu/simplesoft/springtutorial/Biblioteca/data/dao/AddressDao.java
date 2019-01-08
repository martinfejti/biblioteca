package hu.simplesoft.springtutorial.Biblioteca.data.dao;

import java.util.List;

import hu.simplesoft.springtutorial.Biblioteca.data.exception.ElementNotFoundException;
import hu.simplesoft.springtutorial.Biblioteca.data.exception.PersistenceException;
import hu.simplesoft.sprintutorial.Biblioteca.service.dto.AddressDto;

public interface AddressDao {

	boolean createAddress(AddressDto addressDto) throws PersistenceException;
	boolean updateAddress(AddressDto addressDto) throws PersistenceException;
	boolean deleteAddress(long addressId) throws PersistenceException;
	AddressDto getAddressById(long addressId) throws ElementNotFoundException;
	List<AddressDto> getAllAddresses() throws ElementNotFoundException;
}
