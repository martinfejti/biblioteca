package hu.simplesoft.springtutorial.Biblioteca.controller.mapper;

import hu.simplesoft.springtutorial.Biblioteca.controller.request.RoleCreateRequest;
import hu.simplesoft.springtutorial.Biblioteca.controller.request.RoleUpdateRequest;
import hu.simplesoft.sprintutorial.Biblioteca.service.dto.RoleDto;

public class RoleRequestMapper {

	private RoleRequestMapper() {
	}
	
	public static RoleDto convertCreateRequestToDto(RoleCreateRequest roleCreateRequest) {
		RoleDto roleDto = new RoleDto();
		
		roleDto.setRoleName(roleCreateRequest.getName());
		
		return roleDto;
	}
	
	public static RoleDto convertUpdateRequestToDto(RoleUpdateRequest roleUpdateRequest) {
		RoleDto roleDto = new RoleDto();
		
		roleDto.setId(roleUpdateRequest.getId());
		roleDto.setRoleName(roleUpdateRequest.getName());
		
		return roleDto;
	}
}
