package hu.simplesoft.springtutorial.Biblioteca.data.mapper;

import org.mapstruct.Mapper;

import hu.simplesoft.springtutorial.Biblioteca.data.entity.UserEntity;
import hu.simplesoft.sprintutorial.Biblioteca.service.dto.UserDto;

@Mapper
public abstract class UserMapper {

	public abstract UserEntity mapUserDtoToEntity(UserDto userDto);
	public abstract UserDto mapUserEntityToDto(UserEntity userEntity);
}
