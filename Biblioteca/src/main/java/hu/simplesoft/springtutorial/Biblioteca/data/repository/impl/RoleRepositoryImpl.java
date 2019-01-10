package hu.simplesoft.springtutorial.Biblioteca.data.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import hu.simplesoft.springtutorial.Biblioteca.data.entity.RoleEntity;
import hu.simplesoft.springtutorial.Biblioteca.data.exception.ElementNotFoundException;
import hu.simplesoft.springtutorial.Biblioteca.data.exception.PersistenceException;
import hu.simplesoft.springtutorial.Biblioteca.data.repository.RoleRepository;

@Repository
@Transactional
public class RoleRepositoryImpl implements RoleRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	public RoleRepositoryImpl() {
	}
	
	@Override
	public RoleEntity getRoleById(long roleId) throws ElementNotFoundException{
		RoleEntity roleEntity;
		
		try {
			roleEntity = this.entityManager.find(RoleEntity.class, roleId);
		} catch (RuntimeException e) {
			throw new ElementNotFoundException("Element not found!", e);
		}
		return roleEntity;
	}
	
	@Override
	public List<RoleEntity> getAllRoles() throws ElementNotFoundException{
		List<RoleEntity> roleEntityList;
		
		try {
			TypedQuery<RoleEntity> query = this.entityManager.createQuery("SELECT r FROM Role r", RoleEntity.class); 
			roleEntityList = query.getResultList();
		} catch (RuntimeException e) {
			throw new ElementNotFoundException("Element not found!", e);
		}
		
		return roleEntityList;
	}
	
	@Override
	public void createRole(RoleEntity roleEntity) throws PersistenceException{
		 
		try {
			this.entityManager.persist(roleEntity);
		} catch (RuntimeException e) {
			throw new PersistenceException("Create has failed!", e);
		}
	}
	
	@Override
	public void updateRole(RoleEntity roleEntity) throws PersistenceException{
		
		try {
			this.entityManager.merge(roleEntity);
		} catch (RuntimeException e) {
			throw new PersistenceException("Update has failed!", e);
		}
	}
	
	@Override
	public void deleteRole(RoleEntity roleEntity) throws PersistenceException{
		
		try {
			this.entityManager.remove(roleEntity);
		} catch (RuntimeException e) {
			throw new PersistenceException("Delete has failed!", e);
		}
	}
}
