package hu.simplesoft.springtutorial.Biblioteca.data.repository;

import java.util.List;

import hu.simplesoft.springtutorial.Biblioteca.data.entity.AddressEntity;
import hu.simplesoft.springtutorial.Biblioteca.data.exception.ElementNotFoundException;
import hu.simplesoft.springtutorial.Biblioteca.data.exception.PersistenceException;

public interface AddressRepository {

	void createAddress(AddressEntity addressEntity) throws PersistenceException;
	void updateAddress(AddressEntity addressEntity) throws PersistenceException;
	void deleteAddress(AddressEntity addressEntity) throws PersistenceException;
	AddressEntity getAddressById(long addressId) throws ElementNotFoundException;
	List<AddressEntity> getAllAddresses() throws ElementNotFoundException;
        	
}
