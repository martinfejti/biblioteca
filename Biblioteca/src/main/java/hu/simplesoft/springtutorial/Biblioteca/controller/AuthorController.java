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

import hu.simplesoft.springtutorial.Biblioteca.service.AuthorService;
import hu.simplesoft.springtutorial.Biblioteca.service.exception.ServiceException;
import hu.simplesoft.sprintutorial.Biblioteca.service.dto.AuthorDto;

@RestController
@RequestMapping("/author")
public class AuthorController {

	@Autowired
	private AuthorService authorService;
	
	@PostMapping("/createAuthor")
	public void createAuthor(@RequestBody AuthorDto authorDto) throws ServiceException{
		this.authorService.createAuthor(authorDto);
	}
	
	@PutMapping("/updateAuthor")
	public void updateAuthor(@RequestBody AuthorDto authorDto) throws ServiceException{
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
