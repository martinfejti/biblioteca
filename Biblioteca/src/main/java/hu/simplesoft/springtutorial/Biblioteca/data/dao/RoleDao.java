package hu.simplesoft.springtutorial.Biblioteca.data.dao;

import java.util.List;

import hu.simplesoft.springtutorial.Biblioteca.data.exception.ElementNotFoundException;
import hu.simplesoft.springtutorial.Biblioteca.data.exception.ObjectIsNullException;
import hu.simplesoft.springtutorial.Biblioteca.data.exception.PersistenceException;
import hu.simplesoft.sprintutorial.Biblioteca.service.dto.RoleDto;

public interface RoleDao {

	void createRole(RoleDto roleDto) throws PersistenceException;
	void updateRole(RoleDto roleDto) throws PersistenceException, ObjectIsNullException;
	void deleteRole(long roleId) throws PersistenceException, ObjectIsNullException;
	RoleDto getRoleById(long roleId) throws ElementNotFoundException, ObjectIsNullException;
	List<RoleDto> getAllRoles() throws ElementNotFoundException;
}
