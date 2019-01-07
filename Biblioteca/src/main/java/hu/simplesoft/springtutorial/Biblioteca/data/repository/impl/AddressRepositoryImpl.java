package hu.simplesoft.springtutorial.Biblioteca.data.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import hu.simplesoft.springtutorial.Biblioteca.data.entity.AddressEntity;
import hu.simplesoft.springtutorial.Biblioteca.data.repository.iface.AddressRepository;
import hu.simplesoft.springtutorial.Biblioteca.exception.ElementNotFoundException;
import hu.simplesoft.springtutorial.Biblioteca.exception.PersistenceException;

@Repository
@Transactional
public class AddressRepositoryImpl implements AddressRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	public AddressRepositoryImpl() {
		
	}
	
	@Override
	public AddressEntity getAddressById(long addressId) throws Exception{
		AddressEntity foundEntity;
		
		try {
			foundEntity = this.entityManager.find(AddressEntity.class, addressId);
		} catch (ElementNotFoundException e) {
			throw new ElementNotFoundException("Element not found!", e);
		}
		
		return foundEntity;
	}
	
	@Override
	public void createAddress(AddressEntity addressEntity) throws Exception{
		
		try {
			this.entityManager.persist(addressEntity);
		} catch (PersistenceException e) {
			throw new PersistenceException("Create has failed!", e);
		}
		
	}
	
	@Override
	public void updateAddress(AddressEntity addressEntity) throws Exception{
		
		try {
			this.entityManager.merge(addressEntity);
		} catch (PersistenceException e) {
			throw new PersistenceException("Update has failed!", e);
		}
		
	}
	
	@Override 
	public void deleteAddress(AddressEntity addressEntity) throws Exception{
		
		try {
			this.entityManager.remove(addressEntity);
		} catch (PersistenceException e) {
			throw new PersistenceException("Delete has failed!", e);
		}
		
	}
	
}
