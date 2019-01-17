package hu.simplesoft.springtutorial.Biblioteca.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hu.simplesoft.springtutorial.Biblioteca.controller.mapper.AuthorRequestMapper;
import hu.simplesoft.springtutorial.Biblioteca.controller.request.AuthorCreateRequest;
import hu.simplesoft.springtutorial.Biblioteca.controller.request.AuthorUpdateRequest;
import hu.simplesoft.springtutorial.Biblioteca.service.AuthorService;
import hu.simplesoft.springtutorial.Biblioteca.service.exception.ServiceException;
import hu.simplesoft.sprintutorial.Biblioteca.service.dto.AuthorDto;

@RestController
@RequestMapping("/author")
public class AuthorController {

	@Autowired
	private AuthorService authorService;
	
	@PostMapping("/createAuthor")
	public void createAuthor(@Valid @RequestBody AuthorCreateRequest authorCreateRequest) throws ServiceException{
		AuthorDto authorDto = AuthorRequestMapper.convertCreateRequestToDto(authorCreateRequest);
		this.authorService.createAuthor(authorDto);
	}
	
	@PutMapping("/updateAuthor")
	public void updateAuthor(@Valid @RequestBody AuthorUpdateRequest authorUpdateRequest) throws ServiceException{
		AuthorDto authorDto = AuthorRequestMapper.convertUpdateRequestToDto(authorUpdateRequest);
		this.authorService.updateAuthor(authorDto);
	}
	
	@DeleteMapping("/deleteAuthor/{id}")
	public void deleteAuthor(@PathVariable long id) throws ServiceException{
		this.authorService.deleteAuthor(id);
	}
	
	@GetMapping("/getAuthor/{id}")
	public AuthorDto getAuthorById(@PathVariable long id) throws ServiceException{
		AuthorDto authorDto = this.authorService.getAuthorById(id);
		return authorDto;
	}
	
	@GetMapping("/getAllAuthors")
	public List<AuthorDto> getAllAuthors() throws ServiceException{
		List<AuthorDto> authorDtoList = this.authorService.getAllAuthors();
		return authorDtoList;
	}
}
