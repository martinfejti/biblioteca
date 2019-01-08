package hu.simplesoft.springtutorial.Biblioteca.data.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import hu.simplesoft.springtutorial.Biblioteca.data.entity.AddressEntity;
import hu.simplesoft.springtutorial.Biblioteca.data.exception.ElementNotFoundException;
import hu.simplesoft.springtutorial.Biblioteca.data.exception.PersistenceException;
import hu.simplesoft.springtutorial.Biblioteca.data.repository.AddressRepository;

@Repository
@Transactional
public class AddressRepositoryImpl implements AddressRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	public AddressRepositoryImpl() {
	}
	
	@Override
	public AddressEntity getAddressById(long addressId) throws ElementNotFoundException{
		AddressEntity foundEntity;
		
		try {
			foundEntity = this.entityManager.find(AddressEntity.class, addressId);
		} catch (RuntimeException e) {
			throw new ElementNotFoundException("Element not found!", e);
		}
		
		return foundEntity;
	}
	
	@Override
	public List<AddressEntity> getAllAddresses() throws ElementNotFoundException{
		List<AddressEntity> addressEntityList;
		
		try {
			TypedQuery<AddressEntity> query = this.entityManager.createQuery("SELECT a FROM Address a", AddressEntity.class);
			addressEntityList = query.getResultList();
		} catch (RuntimeException e) {
			throw new ElementNotFoundException("Element not found!", e);
		}
		
		return addressEntityList;
		
	}
	
	@Override
	public void createAddress(AddressEntity addressEntity) throws PersistenceException{
		
		try {
			this.entityManager.persist(addressEntity);
		} catch (RuntimeException e) {
			throw new PersistenceException("Create has failed!", e);
		}
		
	}
	
	@Override
	public void updateAddress(AddressEntity addressEntity) throws PersistenceException{
		
		try {
			this.entityManager.merge(addressEntity);
		} catch (RuntimeException e) {
			throw new PersistenceException("Update has failed!", e);
		}
		
	}
	
	@Override 
	public void deleteAddress(AddressEntity addressEntity) throws PersistenceException{
		
		try {
			this.entityManager.remove(addressEntity);
		} catch (RuntimeException e) {
			throw new PersistenceException("Delete has failed!", e);
		}
		
	}
	
}
