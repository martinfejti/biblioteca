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

import hu.simplesoft.springtutorial.Biblioteca.controller.mapper.LoanRequestMapper;
import hu.simplesoft.springtutorial.Biblioteca.controller.request.LoanCreateRequest;
import hu.simplesoft.springtutorial.Biblioteca.controller.request.LoanUpdateRequest;
import hu.simplesoft.springtutorial.Biblioteca.service.LoanService;
import hu.simplesoft.springtutorial.Biblioteca.service.exception.ServiceException;
import hu.simplesoft.sprintutorial.Biblioteca.service.dto.LoanDto;

@RestController
@RequestMapping("/loan")
public class LoanController {

	@Autowired
	private LoanService loanService;
	
	public LoanController() {
	}
	
	@PostMapping("/createLoan")
	public void createLoan(@Valid @RequestBody LoanCreateRequest loanCreateRequest) throws ServiceException{
		LoanDto loanDto = LoanRequestMapper.convertCreateRequestToDto(loanCreateRequest);
		this.loanService.createLoan(loanDto);
	}
	
	@PutMapping("/updateLoan")
	public void updateLoan(@Valid @RequestBody LoanUpdateRequest loanUpdateRequest) throws ServiceException{
		LoanDto loanDto = LoanRequestMapper.convertUpdateRequestToDto(loanUpdateRequest);
		this.loanService.updateLoan(loanDto);
	}
	
	@DeleteMapping("/deleteLoan/{id}")
	public void deleteLoan(@PathVariable @Positive long id) throws ServiceException{
		this.loanService.deleteLoan(id);
	}
	
	@GetMapping("/getLoan/{id}")
	public LoanDto getLoanById(@PathVariable @Positive long id) throws ServiceException{
		LoanDto loanDto = this.loanService.getLoanById(id);
		return loanDto;
	}
	
	@GetMapping("/getAllLoans")
	public List<LoanDto> getAllLoans() throws ServiceException{
		List<LoanDto> loanDtoList = this.loanService.getAllLoans();
		return loanDtoList;
	}
}
