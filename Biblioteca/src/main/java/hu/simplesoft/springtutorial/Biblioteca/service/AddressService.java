package hu.simplesoft.springtutorial.Biblioteca.service;

import java.util.List;

import hu.simplesoft.springtutorial.Biblioteca.service.exception.ServiceException;
import hu.simplesoft.sprintutorial.Biblioteca.service.dto.AddressDto;

public interface AddressService {

	void createAddress(AddressDto addressDto) throws ServiceException;
	void updateAddress(AddressDto addressDto) throws ServiceException;
	void deleteAddress(long addressId) throws ServiceException;
	AddressDto getAddressById(long addressId) throws ServiceException;
	List<AddressDto> getAllAddresses() throws ServiceException;
}
