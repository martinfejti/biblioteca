package hu.simplesoft.springtutorial.Biblioteca.service;

import java.util.List;

import hu.simplesoft.springtutorial.Biblioteca.service.exception.ServiceException;
import hu.simplesoft.sprintutorial.Biblioteca.service.dto.RoleDto;

public interface RoleService {

	void createRole(RoleDto roleDto) throws ServiceException;
	void updateRole(RoleDto roleDto) throws ServiceException;
	void deleteRole(long roleId) throws ServiceException;
	RoleDto getRoleById(long roleId) throws ServiceException;
	List<RoleDto> getAllRoles() throws ServiceException;
}
