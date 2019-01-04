package hu.simplesoft.springtutorial.Biblioteca.data.mapper;


import hu.simplesoft.springtutorial.Biblioteca.data.entity.RoleEntity;
import hu.simplesoft.sprintutorial.Biblioteca.service.dto.RoleDto;

public final class RoleMapper {

	private RoleMapper() {
		
	}
	
	public static RoleEntity convertDtoToEntity(RoleDto roleDto) {
		RoleEntity roleEntity = new RoleEntity();
		
		roleEntity.setRoleId(roleDto.getId());
		roleEntity.setRoleName(roleDto.getRoleName());
		
		return roleEntity;
	}
	
	public static RoleDto convertEntityToDto(RoleEntity roleEntity) {
		RoleDto roleDto = new RoleDto();
		
		roleDto.setId(roleEntity.getRoleId());
		roleDto.setRoleName(roleEntity.getRoleName());
		
		return roleDto;
	}
}
