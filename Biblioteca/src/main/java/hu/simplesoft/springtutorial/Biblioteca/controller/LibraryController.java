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

import hu.simplesoft.springtutorial.Biblioteca.controller.mapper.LibraryRequestMapper;
import hu.simplesoft.springtutorial.Biblioteca.controller.request.LibraryCreateRequest;
import hu.simplesoft.springtutorial.Biblioteca.controller.request.LibraryUpdateRequest;
import hu.simplesoft.springtutorial.Biblioteca.service.LibraryService;
import hu.simplesoft.springtutorial.Biblioteca.service.exception.ServiceException;
import hu.simplesoft.sprintutorial.Biblioteca.service.dto.LibraryDto;

@RestController
@RequestMapping("/library")
public class LibraryController {

	@Autowired
	private LibraryService libraryService;
	
	@PostMapping("/createLibrary")
	public void createLibrary(@Valid @RequestBody LibraryCreateRequest libraryCreateRequest) throws ServiceException{
		LibraryDto libraryDto = LibraryRequestMapper.convertCreateRequestToDto(libraryCreateRequest);
		this.libraryService.createLibrary(libraryDto);
	}
	
	@PutMapping("/updateLibrary")
	public void updateLibrary(@Valid @RequestBody LibraryUpdateRequest libraryUpdateRequest) throws ServiceException{
		LibraryDto libraryDto = LibraryRequestMapper.convertUpdateRequestToDto(libraryUpdateRequest);
		this.libraryService.updateLibrary(libraryDto);
	}
	
	@DeleteMapping("/deleteLibrary/{id}")
	public void deleteLibrary(@PathVariable long id) throws ServiceException{
		this.libraryService.deleteLibrary(id);
	}
	
	@GetMapping("/getLibrary/{id}")
	public LibraryDto getLibraryById(@PathVariable long id) throws ServiceException{
		LibraryDto libraryDto = this.libraryService.getLibraryById(id);
		return libraryDto;
	}
	
	@GetMapping("/getAllLibraries")
	public List<LibraryDto> getAllLibraries() throws ServiceException{
		List<LibraryDto> libraryDtoList = this.libraryService.getAllLibraries();
		return libraryDtoList;
	}
}
