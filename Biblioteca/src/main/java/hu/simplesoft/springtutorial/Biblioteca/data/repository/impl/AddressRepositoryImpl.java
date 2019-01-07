package hu.simplesoft.springtutorial.Biblioteca.data.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import hu.simplesoft.springtutorial.Biblioteca.data.entity.AddressEntity;
import hu.simplesoft.springtutorial.Biblioteca.data.repository.iface.AddressRepository;

@Repository
@Transactional
public class AddressRepositoryImpl implements AddressRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	public AddressRepositoryImpl() {
		
	}
	
	@Override
	public boolean createAddress(AddressEntity addressEntity) {
		boolean isSuccess = false;
		
		try {
			this.entityManager.persist(addressEntity);
			isSuccess = true;
		} catch (RuntimeException e) {
			
		}
		
		return isSuccess;
	}
	
	@Override
	public boolean updateAddress(AddressEntity addressEntity) {
		boolean isSuccess = false;
		
		addressEntity = this.entityManager.find(AddressEntity.class, addressEntity.getAddressId());
		
		try {
			this.entityManager.merge(addressEntity);
			isSuccess = true;
		} catch (RuntimeException e) {
			
		}
		
		return isSuccess;
	}
	
	@Override 
	public boolean deleteAddress(long addressId) {
		boolean isSuccess = false;
		
		AddressEntity addressEntity = this.entityManager.find(AddressEntity.class, addressId);
		
		try {
			this.entityManager.remove(addressEntity);
			isSuccess = true;
		} catch (RuntimeException e) {
			
		}
		
		return isSuccess;
	}
	
}
