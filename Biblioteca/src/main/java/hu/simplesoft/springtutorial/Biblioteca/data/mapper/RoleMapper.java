package hu.simplesoft.springtutorial.Biblioteca.data.mapper;

import org.mapstruct.Mapper;

import hu.simplesoft.springtutorial.Biblioteca.data.entity.RoleEntity;
import hu.simplesoft.sprintutorial.Biblioteca.service.dto.RoleDto;

@Mapper
public abstract class RoleMapper {

	public abstract RoleEntity mapRoleDtoToEntity(RoleDto roleDto);
	public abstract RoleDto mapRoleEntityToDto(RoleEntity roleEntity);
}
