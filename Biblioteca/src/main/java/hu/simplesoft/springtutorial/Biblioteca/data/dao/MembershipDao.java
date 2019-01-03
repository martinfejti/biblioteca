package hu.simplesoft.springtutorial.Biblioteca.data.dao;

import hu.simplesoft.sprintutorial.Biblioteca.service.dto.MembershipDto;

public interface MembershipDao {

	boolean createMembership(MembershipDto membershipDto);
	boolean updateMembership(MembershipDto membershipDto);
	boolean deleteMembership(long membershipId);
	MembershipDto getMembershipById(long membershipId);
}
