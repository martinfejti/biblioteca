package hu.simplesoft.springtutorial.Biblioteca.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.simplesoft.springtutorial.Biblioteca.data.dao.RoleDao;
import hu.simplesoft.springtutorial.Biblioteca.data.exception.PersistenceException;
import hu.simplesoft.springtutorial.Biblioteca.service.RoleService;
import hu.simplesoft.springtutorial.Biblioteca.service.exception.ServiceException;
import hu.simplesoft.sprintutorial.Biblioteca.service.dto.RoleDto;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleDao roleDao;
	
	@Override
	public void createRole(RoleDto roleDto) throws ServiceException{
		try {
			this.roleDao.createRole(roleDto);
		} catch (PersistenceException e) {
			throw new ServiceException("Create has failed!", e);
		}
	}
	
	@Override
	public void updateRole(RoleDto roleDto) throws ServiceException{
		try {
			this.roleDao.updateRole(roleDto);
		} catch (PersistenceException e) {
			throw new ServiceException("Update has failed!",e );
		}
	}
	
	@Override
	public void deleteRole(long roleId) throws ServiceException{
		try {
			this.roleDao.deleteRole(roleId);
		} catch (PersistenceException e) {
			throw new ServiceException("Delete has failed!", e);
		}
	}
	
	@Override
	public RoleDto getRoleById(long roleId) throws ServiceException{
		try {
			return this.roleDao.getRoleById(roleId);
		} catch (PersistenceException e) {
			throw new ServiceException("Element not found!", e);
		}
	}
	
	@Override
	public List<RoleDto> getAllRoles() throws ServiceException{
		try {
			return this.roleDao.getAllRoles();
		} catch (PersistenceException e) {
			throw new ServiceException("Element not found!", e);
		}
	}
}
