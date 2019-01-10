package hu.simplesoft.springtutorial.Biblioteca.data.dao;

import java.util.List;

import hu.simplesoft.springtutorial.Biblioteca.data.exception.ElementNotFoundException;
import hu.simplesoft.springtutorial.Biblioteca.data.exception.PersistenceException;
import hu.simplesoft.sprintutorial.Biblioteca.service.dto.MembershipDto;

public interface MembershipDao {

	void createMembership(MembershipDto membershipDto) throws PersistenceException;
	void updateMembership(MembershipDto membershipDto) throws PersistenceException;
	void deleteMembership(long membershipId) throws PersistenceException;
	MembershipDto getMembershipById(long membershipId) throws ElementNotFoundException;
	List<MembershipDto> getAllMemberships() throws ElementNotFoundException;
}
