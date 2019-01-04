package hu.simplesoft.springtutorial.Biblioteca.data.mapper;


import java.util.ArrayList;
import java.util.List;

import hu.simplesoft.springtutorial.Biblioteca.data.entity.UserEntity;
import hu.simplesoft.sprintutorial.Biblioteca.service.dto.UserDto;

public final class UserMapper {

	private UserMapper() {
		
	}
	
	public static UserEntity convertDtoToEntity(UserDto userDto) {
		UserEntity userEntity = new UserEntity();
		
		userEntity.setUserId(userDto.getId());
		userEntity.setRole(RoleMapper.convertDtoToEntity(userDto.getRole()));
		userEntity.setUsername(userDto.getUsername());
		userEntity.setPassword(userDto.getPassword());
		userEntity.setEmail(userDto.getEmail());
		userEntity.setBirthDate(userDto.getBirthDate());
		userEntity.setName(userDto.getName());
		userEntity.setNationality(userDto.getNationality());
		userEntity.setAddress(AddressMapper.convertDtoToEntity(userDto.getAddress()));
		
		return userEntity;
	}
	
	public static UserDto convertEntityToDto(UserEntity userEntity) {
		UserDto userDto = new UserDto();
		
		userDto.setId(userEntity.getUserId());
		userDto.setRole(RoleMapper.convertEntityToDto(userEntity.getRole()));
		userDto.setUsername(userEntity.getUsername());
		userDto.setPassword(userEntity.getPassword());
		userDto.setEmail(userEntity.getEmail());
		userDto.setBirthDate(userEntity.getBirthDate());
		userDto.setName(userEntity.getName());
		userDto.setNationality(userEntity.getNationality());
		userDto.setAddress(AddressMapper.convertEntityToDto(userEntity.getAddress()));
		
		return userDto;
	}
	
	public static List<UserDto> convertListEntityToDto(List<UserEntity> userEntityList){
		List<UserDto> userDtoList = new ArrayList<>();
		
		for(UserEntity userEntity : userEntityList) {
			userDtoList.add(convertEntityToDto(userEntity));
		}
		
		return userDtoList;
	}
}
