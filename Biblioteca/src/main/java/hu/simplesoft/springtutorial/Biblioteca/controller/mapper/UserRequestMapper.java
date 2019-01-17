package hu.simplesoft.springtutorial.Biblioteca.controller.mapper;

import hu.simplesoft.springtutorial.Biblioteca.controller.request.UserCreateRequest;
import hu.simplesoft.springtutorial.Biblioteca.controller.request.UserUpdateRequest;
import hu.simplesoft.sprintutorial.Biblioteca.service.dto.AddressDto;
import hu.simplesoft.sprintutorial.Biblioteca.service.dto.RoleDto;
import hu.simplesoft.sprintutorial.Biblioteca.service.dto.UserDto;

public final class UserRequestMapper {

	private UserRequestMapper() {
	}
	
	public static UserDto convertCreateRequestToDto(UserCreateRequest userCreateRequest) {
		UserDto userDto = new UserDto();
		RoleDto roleDto = new RoleDto();
		AddressDto addressDto = new AddressDto();
		
		userDto.setRole(roleDto);
		userDto.setUsername(userCreateRequest.getUsername());
		userDto.setEmail(userCreateRequest.getEmail());
		userDto.setPassword(userCreateRequest.getPassword());
		userDto.setBirthDate(userCreateRequest.getBirthdate());
		userDto.setNationality(userCreateRequest.getNationality());
		userDto.setName(userCreateRequest.getRealName());
		userDto.setAddress(addressDto);
		
		return userDto;
	}
	
	public static UserDto convertUpdateRequestToDto(UserUpdateRequest userUpdateRequest) {
		UserDto userDto = new UserDto();
		RoleDto roleDto = new RoleDto();
		AddressDto addressDto = new AddressDto();
		
		userDto.setId(userUpdateRequest.getId());
		userDto.setRole(roleDto);
		userDto.setUsername(userUpdateRequest.getUsername());
		userDto.setEmail(userUpdateRequest.getEmail());
		userDto.setPassword(userUpdateRequest.getPassword());
		userDto.setBirthDate(userUpdateRequest.getBirthdate());
		userDto.setNationality(userUpdateRequest.getNationality());
		userDto.setName(userUpdateRequest.getRealName());
		userDto.setAddress(addressDto);
		
		return userDto;
	}
}
