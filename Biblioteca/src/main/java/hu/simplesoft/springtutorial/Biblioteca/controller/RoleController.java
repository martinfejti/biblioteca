package hu.simplesoft.springtutorial.Biblioteca.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hu.simplesoft.springtutorial.Biblioteca.controller.mapper.RoleRequestMapper;
import hu.simplesoft.springtutorial.Biblioteca.controller.request.RoleCreateRequest;
import hu.simplesoft.springtutorial.Biblioteca.controller.request.RoleUpdateRequest;
import hu.simplesoft.springtutorial.Biblioteca.service.RoleService;
import hu.simplesoft.springtutorial.Biblioteca.service.exception.ServiceException;
import hu.simplesoft.sprintutorial.Biblioteca.service.dto.RoleDto;

@RestController
@RequestMapping("/role")
public class RoleController {

	@Autowired
	private RoleService roleService;
	
	public RoleController() {
	}
	
	@PostMapping("/createRole")
	public void createRole(@Valid @RequestBody RoleCreateRequest roleCreateRequest) throws ServiceException{
		RoleDto roleDto = RoleRequestMapper.convertCreateRequestToDto(roleCreateRequest);
		this.roleService.createRole(roleDto);
	}
	
	@PutMapping("/updateRole")
	public void updateRole(@Valid @RequestBody RoleUpdateRequest roleUpdateRequest) throws ServiceException{
		RoleDto roleDto = RoleRequestMapper.convertUpdateRequestToDto(roleUpdateRequest);
		this.roleService.updateRole(roleDto);
	}
	
	@DeleteMapping("/deleteRole/{id}")
	public void deleteRole(@PathVariable @Positive long id) throws ServiceException{
		this.roleService.deleteRole(id);
	}
	
	@GetMapping("/getRole/{id}")
	public RoleDto getRoleById(@PathVariable @Positive long id) throws ServiceException{
		RoleDto roleDto = this.roleService.getRoleById(id);
		return roleDto;
	}
	
	@GetMapping("/getAllRoles")
	public List<RoleDto> getAllRoles() throws ServiceException{
		List<RoleDto> roleDtoList = this.roleService.getAllRoles();
		return roleDtoList;
	}
}
