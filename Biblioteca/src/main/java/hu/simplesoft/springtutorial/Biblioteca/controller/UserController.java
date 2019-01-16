package hu.simplesoft.springtutorial.Biblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hu.simplesoft.springtutorial.Biblioteca.service.UserService;
import hu.simplesoft.springtutorial.Biblioteca.service.exception.ServiceException;
import hu.simplesoft.sprintutorial.Biblioteca.service.dto.UserDto;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/createUser")
	public void createUser(@RequestBody UserDto userDto) throws ServiceException{
		this.userService.createUser(userDto);
	}
	
	@PutMapping("/updateUser")
	public void updateUser(@RequestBody UserDto userDto) throws ServiceException{
		this.userService.updateUser(userDto);
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public void deleteUser(@PathVariable long id) throws ServiceException{
		this.userService.deleteUser(id);
	}
	
	@GetMapping("getUser/{id}")
	public UserDto getUserById(@PathVariable long id) throws ServiceException{
		UserDto userDto = this.userService.getUserById(id);
		return userDto;
	}
	
	@GetMapping("/getAllUsers")
	public List<UserDto> getAllUsers() throws ServiceException{
		List<UserDto> userDtoList = this.userService.getAllUsers();
		return userDtoList;
	}
}
