package hu.simplesoft.springtutorial.Biblioteca.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.simplesoft.springtutorial.Biblioteca.data.dao.UserDao;
import hu.simplesoft.springtutorial.Biblioteca.data.exception.PersistenceException;
import hu.simplesoft.springtutorial.Biblioteca.service.UserService;
import hu.simplesoft.springtutorial.Biblioteca.service.exception.ServiceException;
import hu.simplesoft.sprintutorial.Biblioteca.service.dto.UserDto;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Override
	public void createUser(UserDto userDto) throws ServiceException{
		try {
			this.userDao.createUser(userDto);
		} catch (PersistenceException e) {
			throw new ServiceException("Create has failed!", e);
		}
	}
	
	@Override
	public void updateUser(UserDto userDto) throws ServiceException{
		try {
			this.userDao.createUser(userDto);
		} catch (PersistenceException e) {
			throw new ServiceException("Update has failed!", e);
		}
	}
	
	@Override
	public void deleteUser(long userId) throws ServiceException{
		try {
			this.userDao.deleteUser(userId);
		} catch (PersistenceException e) {
			throw new ServiceException("Delete has failed!", e);
		}
	}
	
	@Override
	public UserDto getUserById(long userId) throws ServiceException{
		try {
			return this.userDao.getUserById(userId);
		} catch (PersistenceException e) {
			throw new ServiceException("Element not found!", e);
		}
	}
	
	@Override
	public List<UserDto> getAllUsers() throws ServiceException{
		try {
			return this.userDao.getAllUsers();
		} catch (PersistenceException e) {
			throw new ServiceException("Element not found!", e);
		}
	}
}
