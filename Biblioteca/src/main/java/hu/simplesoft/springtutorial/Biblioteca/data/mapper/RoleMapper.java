package hu.simplesoft.springtutorial.Biblioteca.data.mapper;


import java.util.ArrayList;
import java.util.List;

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
	
	public static List<RoleDto> convertListEntityToDto(List<RoleEntity> roleEntityList){
		List<RoleDto> roleDtoList = new ArrayList<>();
		
		for(RoleEntity roleEntity : roleEntityList) {
			roleDtoList.add(convertEntityToDto(roleEntity));
		}
		
		return roleDtoList;
	}
}
