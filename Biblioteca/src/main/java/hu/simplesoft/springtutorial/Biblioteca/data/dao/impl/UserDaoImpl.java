package hu.simplesoft.springtutorial.Biblioteca.data.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hu.simplesoft.springtutorial.Biblioteca.data.dao.UserDao;
import hu.simplesoft.springtutorial.Biblioteca.data.entity.UserEntity;
import hu.simplesoft.springtutorial.Biblioteca.data.exception.ObjectIsNullException;
import hu.simplesoft.springtutorial.Biblioteca.data.exception.PersistenceException;
import hu.simplesoft.springtutorial.Biblioteca.data.mapper.UserMapper;
import hu.simplesoft.springtutorial.Biblioteca.data.repository.UserRepository;
import hu.simplesoft.springtutorial.Biblioteca.data.util.Validator;
import hu.simplesoft.sprintutorial.Biblioteca.service.dto.UserDto;

@Component
public class UserDaoImpl implements UserDao{

	@Autowired
	private UserRepository userRepository;
	
	public UserDaoImpl() {
		
	}
	
	@Override
	public UserDto getUserById(long userId) throws PersistenceException, ObjectIsNullException{
		UserEntity userEntity = this.userRepository.getUserById(userId);
		
		Validator.validateObject(userEntity, userId);
		
		return UserMapper.convertEntityToDto(userEntity);
	}
	
	@Override
	public List<UserDto> getAllUsers() throws PersistenceException{
		List<UserEntity> userEntityList = this.userRepository.getAllUsers();
		
		return UserMapper.convertListEntityToDto(userEntityList);
	}
	
	@Override
	public void createUser(UserDto userDto) throws PersistenceException{
		UserEntity newUserEntity = UserMapper.convertDtoToEntity(userDto);

		this.userRepository.createUser(newUserEntity);
	}
	
	@Override
	public void updateUser(UserDto userDto) throws PersistenceException, ObjectIsNullException{
		UserEntity userEntityForUpdate = this.userRepository.getUserById(userDto.getId());
		
		Validator.validateObject(userEntityForUpdate, userDto.getId());
		
		userEntityForUpdate = updateUserEntity(userEntityForUpdate, userDto);

		this.userRepository.updateUser(userEntityForUpdate);
	}
	
	@Override
	public void deleteUser(long userId) throws PersistenceException, ObjectIsNullException{
		UserEntity userEntityForDelete = this.userRepository.getUserById(userId);
		
		Validator.validateObject(userEntityForDelete, userId);

		this.userRepository.deleteUser(userEntityForDelete);
	}
	
	public UserEntity updateUserEntity(UserEntity originalUserEntity, UserDto newUserDto) {
		UserEntity newUserEntity = UserMapper.convertDtoToEntity(newUserDto);
		
		originalUserEntity.setUserId(newUserEntity.getUserId());
		originalUserEntity.setRole(newUserEntity.getRole());
		originalUserEntity.setUsername(newUserEntity.getUsername());
		originalUserEntity.setEmail(newUserEntity.getEmail());
		originalUserEntity.setPassword(newUserEntity.getPassword());
		originalUserEntity.setBirthDate(newUserEntity.getBirthDate());
		originalUserEntity.setNationality(newUserEntity.getNationality());
		originalUserEntity.setName(newUserEntity.getName());
		originalUserEntity.setAddress(newUserEntity.getAddress());
		
		return originalUserEntity;
	}
}
