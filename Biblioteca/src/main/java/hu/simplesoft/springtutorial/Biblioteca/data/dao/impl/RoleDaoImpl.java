package hu.simplesoft.springtutorial.Biblioteca.data.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Repository;

import hu.simplesoft.springtutorial.Biblioteca.data.dao.RoleDao;
import hu.simplesoft.springtutorial.Biblioteca.data.entity.RoleEntity;
import hu.simplesoft.springtutorial.Biblioteca.data.mapper.RoleMapper;
import hu.simplesoft.springtutorial.Biblioteca.data.util.Constants;
import hu.simplesoft.sprintutorial.Biblioteca.service.dto.RoleDto;

@Repository
@Transactional
public class RoleDaoImpl implements RoleDao{

	private static final Logger LOGGER = LogManager.getLogger(RoleDaoImpl.class);
	private static final RoleMapper ROLE_MAPPER = Mappers.getMapper(RoleMapper.class);
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public RoleDaoImpl() {
		
	}
	
	@Override
	public RoleDto getRoleById(long roleId) {
		RoleEntity roleEntity = entityManager.find(RoleEntity.class, roleId);
		
		return ROLE_MAPPER.mapRoleEntityToDto(roleEntity);
	}
	
	@Override
	public boolean createRole(RoleDto roleDto) {
		boolean isSuccess = false;
		RoleEntity newRoleEntity = ROLE_MAPPER.mapRoleDtoToEntity(roleDto);
		
		try {
			this.entityManager.persist(newRoleEntity);
			isSuccess = true;
		} catch (RuntimeException e) {
			LOGGER.error(Constants.RoleDaoErrorLogMessage.CREATE_FAILED);
		}
		
		return isSuccess;
	}
	
	@Override
	public boolean updateRole(RoleDto roleDto) {
		boolean isSuccess = false;
		RoleEntity roleEntityForUpdate = entityManager.find(RoleEntity.class, roleDto.getId());
		
		if(roleEntityForUpdate != null) {
			roleEntityForUpdate = updateRoleEntity(roleEntityForUpdate, roleDto);
			
			try {
				this.entityManager.merge(roleEntityForUpdate);
				isSuccess = true;
			} catch (RuntimeException e) {
				LOGGER.error(Constants.RoleDaoErrorLogMessage.UPDATE_FAILED);
			}
		}
		
		return isSuccess;
	}
	
	@Override
	public boolean deleteRole(long roleId) {
		boolean isSuccess = false;
		RoleEntity roleEntityForDelete = entityManager.find(RoleEntity.class, roleId);
		
		try {
			this.entityManager.remove(roleEntityForDelete);
			isSuccess = true;
		} catch (RuntimeException e) {
			LOGGER.error(Constants.RoleDaoErrorLogMessage.DELETE_FAILED);
		}
		
		return isSuccess;
	}
	
	public RoleEntity updateRoleEntity(RoleEntity originalRoleEntity, RoleDto newRoleDto) {
		RoleEntity newRoleEntity = ROLE_MAPPER.mapRoleDtoToEntity(newRoleDto);
		
		originalRoleEntity.setRoleId(newRoleEntity.getRoleId());
		originalRoleEntity.setRoleName(newRoleEntity.getRoleName());
		
		return originalRoleEntity;
	}
}
