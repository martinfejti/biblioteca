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

import hu.simplesoft.springtutorial.Biblioteca.controller.mapper.BookRequestMapper;
import hu.simplesoft.springtutorial.Biblioteca.controller.request.BookCreateRequest;
import hu.simplesoft.springtutorial.Biblioteca.controller.request.BookUpdateRequest;
import hu.simplesoft.springtutorial.Biblioteca.service.BookService;
import hu.simplesoft.springtutorial.Biblioteca.service.exception.ServiceException;
import hu.simplesoft.sprintutorial.Biblioteca.service.dto.BookDto;

@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	private BookService bookService;
	
	public BookController() {
	}
	
	@PostMapping("/createBook")
	public void createBook(@Valid @RequestBody BookCreateRequest bookCreateRequest) throws ServiceException{
		BookDto bookDto = BookRequestMapper.convertCreateRequestToDto(bookCreateRequest);
		this.bookService.createBook(bookDto);
	}
	
	@PutMapping("/updateBook")
	public void updateBook(@Valid @RequestBody BookUpdateRequest bookUpdateRequest) throws ServiceException{
		BookDto bookDto = BookRequestMapper.convertUpdateRequestToDto(bookUpdateRequest);
		this.bookService.updateBook(bookDto);
	}
	
	@DeleteMapping("/deleteBook/{id}")
	public void deleteBook(@PathVariable @Positive long id) throws ServiceException{
		this.bookService.deleteBook(id);
	}
	
	@GetMapping("/getBook/{id}")
	public BookDto getBookById(@PathVariable @Positive long id) throws ServiceException{
		BookDto bookDto = this.bookService.getBookById(id);
		return bookDto;
	}
	
	@GetMapping("/getAllBooks")
	public List<BookDto> getAllBooks() throws ServiceException{
		List<BookDto> bookDtoList = this.bookService.getAllBooks();
		return bookDtoList;
	}
}
