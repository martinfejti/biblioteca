package hu.simplesoft.springtutorial.Biblioteca.data.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import hu.simplesoft.springtutorial.Biblioteca.data.entity.UserEntity;
import hu.simplesoft.springtutorial.Biblioteca.data.exception.ElementNotFoundException;
import hu.simplesoft.springtutorial.Biblioteca.data.exception.PersistenceException;
import hu.simplesoft.springtutorial.Biblioteca.data.repository.UserRepository;

@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	public UserRepositoryImpl() {
	}
	
	@Override
	public UserEntity getUserById(long userId) throws ElementNotFoundException{
		UserEntity userEntity;
		
		try {
			userEntity = this.entityManager.find(UserEntity.class, userId);
		} catch (RuntimeException e) {
			throw new ElementNotFoundException("Element not found!", e);
		}
		
		return userEntity;
	}
	
	@Override
	public List<UserEntity> getAllUsers() throws ElementNotFoundException{
		List<UserEntity> userEntityList;
		
		try {
			TypedQuery<UserEntity> query = this.entityManager.createQuery("SELECT u FROM User u", UserEntity.class);
			userEntityList = query.getResultList();
		} catch (RuntimeException e) {
			throw new ElementNotFoundException("Element not found!", e);
		}
		
		return userEntityList;
	}
	
	@Override
	public void createUser(UserEntity userEntity) throws PersistenceException{
		
		try {
			this.entityManager.persist(userEntity);
		} catch (RuntimeException e) {
			throw new PersistenceException("Create has failed!", e);
		}
	}
	
	@Override
	public void updateUser(UserEntity userEntity) throws PersistenceException{
		
		try {
			this.entityManager.merge(userEntity);
		} catch (RuntimeException e) {
			throw new PersistenceException("Update has failed!", e);
		}
	}
	
	@Override
	public void deleteUser(UserEntity userEntity) throws PersistenceException{
		
		try {
			this.entityManager.remove(userEntity);
		} catch (RuntimeException e) {
			throw new PersistenceException("Delete has failed!", e);
		}
	}
}
