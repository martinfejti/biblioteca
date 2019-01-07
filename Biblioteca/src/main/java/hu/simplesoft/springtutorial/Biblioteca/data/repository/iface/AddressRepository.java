package hu.simplesoft.springtutorial.Biblioteca.data.repository.iface;

import hu.simplesoft.springtutorial.Biblioteca.data.entity.AddressEntity;

public interface AddressRepository {

	boolean createAddress(AddressEntity addressEntity);
	boolean updateAddress(AddressEntity addressEntity);
	boolean deleteAddress(long addressId);
	
}
