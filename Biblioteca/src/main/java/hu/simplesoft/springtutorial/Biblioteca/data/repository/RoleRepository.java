package hu.simplesoft.springtutorial.Biblioteca.data.repository;

import java.util.List;

import hu.simplesoft.springtutorial.Biblioteca.data.entity.RoleEntity;
import hu.simplesoft.springtutorial.Biblioteca.data.exception.ElementNotFoundException;
import hu.simplesoft.springtutorial.Biblioteca.data.exception.PersistenceException;

public interface RoleRepository {

	void createRole(RoleEntity roleEntity) throws PersistenceException;
	void updateRole(RoleEntity roleEntity) throws PersistenceException;
	void deleteRole(RoleEntity roleEntity) throws PersistenceException;
	RoleEntity getRoleById(long roleId) throws ElementNotFoundException;
	List<RoleEntity> getAllRoles() throws ElementNotFoundException;
	
}
