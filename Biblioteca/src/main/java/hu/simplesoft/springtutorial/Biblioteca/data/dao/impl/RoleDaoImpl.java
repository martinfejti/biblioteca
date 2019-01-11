package hu.simplesoft.springtutorial.Biblioteca.data.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hu.simplesoft.springtutorial.Biblioteca.data.dao.RoleDao;
import hu.simplesoft.springtutorial.Biblioteca.data.entity.RoleEntity;
import hu.simplesoft.springtutorial.Biblioteca.data.exception.ElementNotFoundException;
import hu.simplesoft.springtutorial.Biblioteca.data.exception.ObjectIsNullException;
import hu.simplesoft.springtutorial.Biblioteca.data.exception.PersistenceException;
import hu.simplesoft.springtutorial.Biblioteca.data.mapper.RoleMapper;
import hu.simplesoft.springtutorial.Biblioteca.data.repository.RoleRepository;
import hu.simplesoft.springtutorial.Biblioteca.data.util.Validator;
import hu.simplesoft.sprintutorial.Biblioteca.service.dto.RoleDto;

@Component
public class RoleDaoImpl implements RoleDao{

	@Autowired
	private RoleRepository roleRepository;
	
	public RoleDaoImpl() {
	}
	
	@Override
	public RoleDto getRoleById(long roleId) throws ElementNotFoundException, ObjectIsNullException{
		RoleEntity roleEntity = this.roleRepository.getRoleById(roleId);
		
		Validator.validateObject(roleEntity, roleId);
		
		return RoleMapper.convertEntityToDto(roleEntity);
	}
	
	@Override
	public List<RoleDto> getAllRoles() throws ElementNotFoundException{
		List<RoleEntity> roleEntityList = this.roleRepository.getAllRoles();
		
		return RoleMapper.convertListEntityToDto(roleEntityList);
	}
	
	@Override
	public void createRole(RoleDto roleDto) throws PersistenceException{
		RoleEntity newRoleEntity = RoleMapper.convertDtoToEntity(roleDto);
		
		this.roleRepository.createRole(newRoleEntity);
	}
	
	@Override
	public void updateRole(RoleDto roleDto) throws PersistenceException, ObjectIsNullException{
		RoleEntity roleEntityForUpdate = this.roleRepository.getRoleById(roleDto.getId());
		
		Validator.validateObject(roleEntityForUpdate, roleDto.getId());
		
		roleEntityForUpdate = updateRoleEntity(roleEntityForUpdate, roleDto);

		this.roleRepository.updateRole(roleEntityForUpdate);
	}
	
	@Override
	public void deleteRole(long roleId) throws PersistenceException, ObjectIsNullException{
		RoleEntity roleEntityForDelete = this.roleRepository.getRoleById(roleId);
		
		Validator.validateObject(roleEntityForDelete, roleId);

		this.roleRepository.deleteRole(roleEntityForDelete);
	}
	
	public RoleEntity updateRoleEntity(RoleEntity originalRoleEntity, RoleDto newRoleDto) {
		RoleEntity newRoleEntity = RoleMapper.convertDtoToEntity(newRoleDto);
		
		originalRoleEntity.setRoleId(newRoleEntity.getRoleId());
		originalRoleEntity.setRoleName(newRoleEntity.getRoleName());
		
		return originalRoleEntity;
	}
}
