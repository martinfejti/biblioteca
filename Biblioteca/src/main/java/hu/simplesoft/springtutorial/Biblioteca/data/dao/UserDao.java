package hu.simplesoft.springtutorial.Biblioteca.data.dao;

import java.util.List;

import hu.simplesoft.springtutorial.Biblioteca.data.exception.ElementNotFoundException;
import hu.simplesoft.springtutorial.Biblioteca.data.exception.PersistenceException;
import hu.simplesoft.sprintutorial.Biblioteca.service.dto.UserDto;

public interface UserDao {

	void createUser(UserDto userDto) throws PersistenceException;
	void updateUser(UserDto userDto) throws PersistenceException;
	void deleteUser(long userId) throws PersistenceException;
	UserDto getUserById(long userId) throws ElementNotFoundException;
	List<UserDto> getAllUsers() throws ElementNotFoundException;
}
