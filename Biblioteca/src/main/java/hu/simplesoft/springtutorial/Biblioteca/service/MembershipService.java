package hu.simplesoft.springtutorial.Biblioteca.service;

import java.util.List;

import hu.simplesoft.springtutorial.Biblioteca.service.exception.ServiceException;
import hu.simplesoft.sprintutorial.Biblioteca.service.dto.MembershipDto;

public interface MembershipService {

	void createMembership(MembershipDto membershipDto) throws ServiceException;
	void updateMembership(MembershipDto membershipDto) throws ServiceException;
	void deleteMembership(long membershipId) throws ServiceException;
	MembershipDto getMembershipById(long membershipId) throws ServiceException;
	List<MembershipDto> getAllMemberships() throws ServiceException;
}
