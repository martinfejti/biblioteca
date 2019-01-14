package hu.simplesoft.springtutorial.Biblioteca.service;

import java.util.List;

import hu.simplesoft.springtutorial.Biblioteca.service.exception.ServiceException;
import hu.simplesoft.sprintutorial.Biblioteca.service.dto.UserDto;

public interface UserService {

	void createUser(UserDto userDto) throws ServiceException;
	void updateUser(UserDto userDto) throws ServiceException;
	void deleteUser(long userId) throws ServiceException;
	UserDto getUserById(long userId) throws ServiceException;
	List<UserDto> getAllUsers() throws ServiceException;
}
