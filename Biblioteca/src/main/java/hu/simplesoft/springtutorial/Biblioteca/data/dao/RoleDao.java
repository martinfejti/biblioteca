package hu.simplesoft.springtutorial.Biblioteca.data.dao;

import hu.simplesoft.sprintutorial.Biblioteca.service.dto.RoleDto;

public interface RoleDao {

	boolean createRole(RoleDto roleDto);
	boolean updateRole(RoleDto roleDto);
	boolean deleteRole(long roleId);
	RoleDto getRoleById(long roleId);
}
