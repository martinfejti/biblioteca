package hu.simplesoft.springtutorial.Biblioteca.data.dao;

import hu.simplesoft.sprintutorial.Biblioteca.service.dto.UserDto;

public interface UserDao {

	boolean createUser(UserDto userDto);
	boolean updateUser(UserDto userDto);
	boolean deleteUser(long userId);
	UserDto getUserByUserName(String username);
}
