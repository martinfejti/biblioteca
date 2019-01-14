package hu.simplesoft.springtutorial.Biblioteca.data.repository;

import java.util.List;

import hu.simplesoft.springtutorial.Biblioteca.data.entity.MembershipEntity;
import hu.simplesoft.springtutorial.Biblioteca.data.exception.PersistenceException;

public interface MembershipRepository {

	void createMembership(MembershipEntity membershipEntity) throws PersistenceException;
	void updateMembership(MembershipEntity membershipEntity) throws PersistenceException;
	void deleteMembership(MembershipEntity membershipEntity) throws PersistenceException;
	MembershipEntity getMembershipById(long membershipId) throws PersistenceException;
	List<MembershipEntity> getAllMemberships() throws PersistenceException;
	
}
