package hu.simplesoft.springtutorial.Biblioteca.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.simplesoft.springtutorial.Biblioteca.data.dao.MembershipDao;
import hu.simplesoft.springtutorial.Biblioteca.data.exception.PersistenceException;
import hu.simplesoft.springtutorial.Biblioteca.service.MembershipService;
import hu.simplesoft.springtutorial.Biblioteca.service.exception.ServiceException;
import hu.simplesoft.sprintutorial.Biblioteca.service.dto.MembershipDto;

@Service
public class MembershipServiceImpl implements MembershipService{

	@Autowired
	private MembershipDao membershipDao;
	
	@Override
	public void createMembership(MembershipDto membershipDto) throws ServiceException{
		try {
			this.membershipDao.createMembership(membershipDto);
		} catch (PersistenceException e) {
			throw new ServiceException("Create has failed!", e);
		}
	}
	
	@Override
	public void updateMembership(MembershipDto membershipDto) throws ServiceException{
		try {
			this.membershipDao.updateMembership(membershipDto);
		} catch (PersistenceException e) {
			throw new ServiceException("Update has failed!", e);
		}
	}
	
	@Override
	public void deleteMembership(long membershipId) throws ServiceException{
		try {
			this.membershipDao.deleteMembership(membershipId);
		} catch (PersistenceException e) {
			throw new ServiceException("Delete has failed!", e);
		}
	}
	
	@Override
	public MembershipDto getMembershipById(long membershipId) throws ServiceException{
		try {
			return this.membershipDao.getMembershipById(membershipId);
		} catch (PersistenceException e) {
			throw new ServiceException("Element not found!", e);
		}
	}
	
	@Override
	public List<MembershipDto> getAllMemberships() throws ServiceException{
		try {
			return this.membershipDao.getAllMemberships();
		} catch (PersistenceException e) {
			throw new ServiceException("Element not found!", e);
		}
	}
}
