package hu.simplesoft.springtutorial.Biblioteca.data.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import hu.simplesoft.springtutorial.Biblioteca.data.entity.MembershipEntity;
import hu.simplesoft.springtutorial.Biblioteca.data.exception.ElementNotFoundException;
import hu.simplesoft.springtutorial.Biblioteca.data.exception.PersistenceException;
import hu.simplesoft.springtutorial.Biblioteca.data.repository.MembershipRepository;

@Repository
@Transactional
public class MembershipRepositoryImpl implements MembershipRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	public MembershipRepositoryImpl() {
	}
	
	@Override
	public MembershipEntity getMembershipById(long membershipId) throws PersistenceException{
		MembershipEntity membershipEntity;
		
		try {
			membershipEntity = this.entityManager.find(MembershipEntity.class, membershipId);
		} catch (RuntimeException e) {
			throw new ElementNotFoundException("Element not found!", e);
		}
		
		return membershipEntity;
	}
	
	@Override
	public List<MembershipEntity> getAllMemberships() throws PersistenceException{
		List<MembershipEntity> membershipEntityList;
		
		try {
			TypedQuery<MembershipEntity> query = this.entityManager.createQuery("SELECT m FROM Membership m", MembershipEntity.class);
			membershipEntityList = query.getResultList();
		} catch (RuntimeException e) {
			throw new ElementNotFoundException("Element not found!", e);
		}
		
		return membershipEntityList;
	}
	
	@Override
	public void createMembership(MembershipEntity membershipEntity) throws PersistenceException{
		
		try {
			this.entityManager.persist(membershipEntity);
		} catch (RuntimeException e) {
			throw new PersistenceException("Create has failed!", e);
		}
	}
	
	@Override
	public void updateMembership(MembershipEntity membershipEntity) throws PersistenceException{
		
		try {
			this.entityManager.merge(membershipEntity);
		} catch (RuntimeException e) {
			throw new PersistenceException("Update has failed!", e);
		}
	}
	
	@Override
	public void deleteMembership(MembershipEntity membershipEntity) throws PersistenceException{
		
		try {
			this.entityManager.remove(membershipEntity);
		} catch (RuntimeException e) {
			throw new PersistenceException("Delete has failed!", e);
		}
	}
}
