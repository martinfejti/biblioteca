package hu.simplesoft.springtutorial.Biblioteca.data.dao;

import java.util.List;

import hu.simplesoft.springtutorial.Biblioteca.data.exception.ElementNotFoundException;
import hu.simplesoft.springtutorial.Biblioteca.data.exception.PersistenceException;
import hu.simplesoft.sprintutorial.Biblioteca.service.dto.RoleDto;

public interface RoleDao {

	void createRole(RoleDto roleDto) throws PersistenceException;
	void updateRole(RoleDto roleDto) throws PersistenceException;
	void deleteRole(long roleId) throws PersistenceException;
	RoleDto getRoleById(long roleId) throws ElementNotFoundException;
	List<RoleDto> getAllRoles() throws ElementNotFoundException;
}
