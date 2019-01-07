package hu.simplesoft.springtutorial.Biblioteca.data.repository;

import hu.simplesoft.springtutorial.Biblioteca.data.entity.AddressEntity;

public interface AddressRepository {

	void createAddress(AddressEntity addressEntity) throws Exception;
	void updateAddress(AddressEntity addressEntity) throws Exception;
	void deleteAddress(AddressEntity addressEntity) throws Exception;
	AddressEntity getAddressById(long addressId) throws Exception;
	
}
