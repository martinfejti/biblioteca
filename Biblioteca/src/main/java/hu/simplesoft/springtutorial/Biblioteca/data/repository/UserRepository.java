package hu.simplesoft.springtutorial.Biblioteca.data.repository;

import java.util.List;

import hu.simplesoft.springtutorial.Biblioteca.data.entity.UserEntity;
import hu.simplesoft.springtutorial.Biblioteca.data.exception.PersistenceException;

public interface UserRepository {

	void createUser(UserEntity userEntity) throws PersistenceException;
	void updateUser(UserEntity userEntity) throws PersistenceException;
	void deleteUser(UserEntity userEntity) throws PersistenceException;
	UserEntity getUserById(long userId) throws PersistenceException;
	List<UserEntity> getAllUsers() throws PersistenceException;
	
}
