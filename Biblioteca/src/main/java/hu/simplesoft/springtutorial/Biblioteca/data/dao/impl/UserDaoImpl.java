package hu.simplesoft.springtutorial.Biblioteca.data.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import hu.simplesoft.springtutorial.Biblioteca.data.dao.UserDao;
import hu.simplesoft.springtutorial.Biblioteca.data.entity.UserEntity;
import hu.simplesoft.springtutorial.Biblioteca.data.mapper.UserMapper;
import hu.simplesoft.sprintutorial.Biblioteca.service.dto.UserDto;

@Repository
@Transactional
public class UserDaoImpl implements UserDao{

	@PersistenceContext
	private EntityManager entityManager;
	
	public UserDaoImpl() {
		
	}
	
	@Override
	public UserDto getUserByUserName(String username) {
		UserEntity userEntity = entityManager.find(UserEntity.class, username);
		
		return UserMapper.convertEntityToDto(userEntity);
	}
	
	@Override
	public boolean createUser(UserDto userDto) {
		boolean isSuccess = false;
		UserEntity newUserEntity = UserMapper.convertDtoToEntity(userDto);
		
		try {
			entityManager.persist(newUserEntity);
			isSuccess = true;
		} catch(RuntimeException e) {
		}
		
		return isSuccess;
	}
	
	@Override
	public boolean updateUser(UserDto userDto) {
		boolean isSuccess = false;
		UserEntity userEntityForUpdate = entityManager.find(UserEntity.class, userDto.getId());
		
		if(userEntityForUpdate != null) {
			userEntityForUpdate = updateUserEntity(userEntityForUpdate, userDto);
			
			try {
				this.entityManager.merge(userEntityForUpdate);
				isSuccess = true;
			} catch (RuntimeException e) {
			}
		}
		
		return isSuccess;
	}
	
	@Override
	public boolean deleteUser(long userId) {
		boolean isSuccess = false;
		UserEntity userEntityForDelete = entityManager.find(UserEntity.class, userId);
		
		try {
			this.entityManager.remove(userEntityForDelete);
			isSuccess = true;
		} catch(RuntimeException e) {
		}
		
		return isSuccess;
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
