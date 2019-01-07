package hu.simplesoft.springtutorial.Biblioteca.data.repository.iface;

import hu.simplesoft.springtutorial.Biblioteca.data.entity.AddressEntity;

public interface AddressRepository {

	void createAddress(AddressEntity addressEntity);
	void updateAddress(AddressEntity addressEntity);
	void deleteAddress(AddressEntity addressEntity);
	AddressEntity getAddressById(long addressId);
	
}
