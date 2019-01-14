package hu.simplesoft.springtutorial.Biblioteca.data.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hu.simplesoft.springtutorial.Biblioteca.data.dao.MembershipDao;
import hu.simplesoft.springtutorial.Biblioteca.data.entity.MembershipEntity;
import hu.simplesoft.springtutorial.Biblioteca.data.exception.ObjectIsNullException;
import hu.simplesoft.springtutorial.Biblioteca.data.exception.PersistenceException;
import hu.simplesoft.springtutorial.Biblioteca.data.mapper.MembershipMapper;
import hu.simplesoft.springtutorial.Biblioteca.data.repository.MembershipRepository;
import hu.simplesoft.springtutorial.Biblioteca.data.util.Validator;
import hu.simplesoft.sprintutorial.Biblioteca.service.dto.MembershipDto;

@Component
public class MembershipDaoImpl implements MembershipDao{

	@Autowired
	private MembershipRepository membershipRepository;
	
	public MembershipDaoImpl() {
	}
	
	@Override
	public MembershipDto getMembershipById(long membershipId) throws PersistenceException, ObjectIsNullException{
		MembershipEntity membershipEntity = this.membershipRepository.getMembershipById(membershipId);
		
		Validator.validateObject(membershipEntity, membershipId);
		
		return MembershipMapper.convertEntityToDto(membershipEntity);
	}
	
	@Override
	public List<MembershipDto> getAllMemberships() throws PersistenceException{
		List<MembershipEntity> membershipEntityList = this.membershipRepository.getAllMemberships();
		
		return MembershipMapper.convertListEntityToDto(membershipEntityList);
	}
	
	@Override
	public void createMembership(MembershipDto membershipDto) throws PersistenceException{
		
		MembershipEntity newMembershipEntity = MembershipMapper.convertDtoToEntity(membershipDto);

		this.membershipRepository.createMembership(newMembershipEntity);
	
	}
	
	@Override
	public void updateMembership(MembershipDto membershipDto) throws PersistenceException, ObjectIsNullException{
		MembershipEntity membershipEntityForUpdate = this.membershipRepository.getMembershipById(membershipDto.getId());
		
		Validator.validateObject(membershipEntityForUpdate, membershipDto.getId());
		
		membershipEntityForUpdate = updateMembershipEntity(membershipEntityForUpdate, membershipDto);
		
		this.membershipRepository.updateMembership(membershipEntityForUpdate);
	}
	
	@Override
	public void deleteMembership(long membershipId) throws PersistenceException, ObjectIsNullException{
		MembershipEntity membershipEntityForDelete = this.membershipRepository.getMembershipById(membershipId);
		
		Validator.validateObject(membershipEntityForDelete, membershipId);
		
		this.membershipRepository.deleteMembership(membershipEntityForDelete);
	}
	
	public MembershipEntity updateMembershipEntity(MembershipEntity originalMembershipEntity, MembershipDto newMembershipDto) {
		MembershipEntity newMembershipEntity = MembershipMapper.convertDtoToEntity(newMembershipDto);
		
		originalMembershipEntity.setMembershipId(newMembershipEntity.getMembershipId());
		originalMembershipEntity.setUser(newMembershipEntity.getUser());
		originalMembershipEntity.setLibrary(newMembershipEntity.getLibrary());
		originalMembershipEntity.setBeginningOfMembership(newMembershipEntity.getBeginningOfMembership());
		
		return originalMembershipEntity;
	}
}
