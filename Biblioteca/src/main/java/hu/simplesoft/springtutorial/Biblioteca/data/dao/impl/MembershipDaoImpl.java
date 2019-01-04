package hu.simplesoft.springtutorial.Biblioteca.data.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Repository;

import hu.simplesoft.springtutorial.Biblioteca.data.dao.MembershipDao;
import hu.simplesoft.springtutorial.Biblioteca.data.entity.MembershipEntity;
import hu.simplesoft.springtutorial.Biblioteca.data.mapper.MembershipMapper;
import hu.simplesoft.springtutorial.Biblioteca.data.util.Constants;
import hu.simplesoft.sprintutorial.Biblioteca.service.dto.MembershipDto;

@Repository
@Transactional
public class MembershipDaoImpl implements MembershipDao{

	private static final Logger LOGGER = LogManager.getLogger(MembershipDaoImpl.class);
	private static final MembershipMapper MEMBERSHIP_MAPPER = Mappers.getMapper(MembershipMapper.class);
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public MembershipDaoImpl() {
		
	}
	
	@Override
	public MembershipDto getMembershipById(long membershipId) {
		MembershipEntity membershipEntity = entityManager.find(MembershipEntity.class, membershipId);
		
		return MEMBERSHIP_MAPPER.mapMembershipEntityToDto(membershipEntity);
	}
	
	@Override
	public boolean createMembership(MembershipDto membershipDto) {
		boolean isSuccess = false;
		MembershipEntity newMembershipEntity = MEMBERSHIP_MAPPER.mapMembershipDtoToEntity(membershipDto);
		
		try {
			this.entityManager.persist(newMembershipEntity);
			isSuccess = true;
		} catch(RuntimeException e) {
			LOGGER.error(Constants.MembershipDaoErrorLogMessage.CREATE_FAILED);
		}
		
		return isSuccess;
	}
	
	@Override
	public boolean updateMembership(MembershipDto membershipDto) {
		boolean isSuccess = false;
		MembershipEntity membershipEntityForUpdate = entityManager.find(MembershipEntity.class, membershipDto.getId());
		
		if(membershipEntityForUpdate != null) {
			membershipEntityForUpdate = updateMembershipEntity(membershipEntityForUpdate, membershipDto);
			
			try {
				this.entityManager.merge(membershipEntityForUpdate);
				isSuccess = true;
			} catch (RuntimeException e) {
				LOGGER.error(Constants.MembershipDaoErrorLogMessage.UPDATE_FAILED);
			}
		}
		
		return isSuccess;
	}
	
	@Override
	public boolean deleteMembership(long membershipId) {
		boolean isSuccess = false;
		MembershipEntity membershipEntityForDelete = entityManager.find(MembershipEntity.class, membershipId);
		
		try {
			this.entityManager.remove(membershipEntityForDelete);
			isSuccess = true;
		} catch(RuntimeException e) {
			LOGGER.error(Constants.MembershipDaoErrorLogMessage.DELETE_FAILED);
		}
		
		return isSuccess;
	}
	
	public MembershipEntity updateMembershipEntity(MembershipEntity originalMembershipEntity, MembershipDto newMembershipDto) {
		MembershipEntity newMembershipEntity = MEMBERSHIP_MAPPER.mapMembershipDtoToEntity(newMembershipDto);
		
		originalMembershipEntity.setMembershipId(newMembershipEntity.getMembershipId());
		originalMembershipEntity.setUser(newMembershipEntity.getUser());
		originalMembershipEntity.setLibrary(newMembershipEntity.getLibrary());
		originalMembershipEntity.setBeginningOfMembership(newMembershipEntity.getBeginningOfMembership());
		
		return originalMembershipEntity;
	}
}
