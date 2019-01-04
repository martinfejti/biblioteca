package hu.simplesoft.springtutorial.Biblioteca.data.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Repository;

import hu.simplesoft.springtutorial.Biblioteca.data.dao.UserDao;
import hu.simplesoft.springtutorial.Biblioteca.data.entity.UserEntity;
import hu.simplesoft.springtutorial.Biblioteca.data.mapper.UserMapper;
import hu.simplesoft.springtutorial.Biblioteca.data.util.Constants;
import hu.simplesoft.sprintutorial.Biblioteca.service.dto.UserDto;

@Repository
@Transactional
public class UserDaoImpl implements UserDao{

	private static final Logger LOGGER = LogManager.getLogger(UserDaoImpl.class);
	private static final UserMapper USER_MAPPER = Mappers.getMapper(UserMapper.class);
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public UserDaoImpl() {
		
	}
	
	@Override
	public UserDto getUserByUserName(String username) {
		UserEntity userEntity = entityManager.find(UserEntity.class, username);
		
		return USER_MAPPER.mapUserEntityToDto(userEntity);
	}
	
	@Override
	public boolean createUser(UserDto userDto) {
		boolean isSuccess = false;
		UserEntity newUserEntity = USER_MAPPER.mapUserDtoToEntity(userDto);
		
		try {
			entityManager.persist(newUserEntity);
			isSuccess = true;
		} catch(RuntimeException e) {
			LOGGER.error(Constants.UserDaoErrorLogMessage.CREATE_FAILED);
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
				LOGGER.error(Constants.UserDaoErrorLogMessage.UPDATE_FAILED);
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
			LOGGER.error(Constants.UserDaoErrorLogMessage.DELETE_FAILED);
		}
		
		return isSuccess;
	}
	
	public UserEntity updateUserEntity(UserEntity originalUserEntity, UserDto newUserDto) {
		UserEntity newUserEntity = USER_MAPPER.mapUserDtoToEntity(newUserDto);
		
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
