package hu.simplesoft.springtutorial.Biblioteca.controller.mapper;

import hu.simplesoft.springtutorial.Biblioteca.controller.request.LoanCreateRequest;
import hu.simplesoft.springtutorial.Biblioteca.controller.request.LoanUpdateRequest;
import hu.simplesoft.sprintutorial.Biblioteca.service.dto.BookDto;
import hu.simplesoft.sprintutorial.Biblioteca.service.dto.LoanDto;
import hu.simplesoft.sprintutorial.Biblioteca.service.dto.UserDto;

public final class LoanRequestMapper {

	private LoanRequestMapper() {
	}
	
	public static LoanDto convertCreateRequestToDto(LoanCreateRequest loanCreateRequest) {
		LoanDto loanDto = new LoanDto();
		BookDto bookDto = new BookDto();
		UserDto userDto = new UserDto();
		
		loanDto.setBook(bookDto);
		loanDto.setUser(userDto);
		loanDto.setLoanStartedDate(loanCreateRequest.getLoanStartedDate());
		loanDto.setLoanEndsDate(loanCreateRequest.getLoanEndsDate());
		loanDto.setStatus(loanCreateRequest.getStatus());
		
		return loanDto;
	}
	
	public static LoanDto convertUpdateRequestToDto(LoanUpdateRequest loanUpdateRequest) {
		LoanDto loanDto = new LoanDto();
		BookDto bookDto = new BookDto();
		UserDto userDto = new UserDto();
		
		loanDto.setId(loanUpdateRequest.getId());
		loanDto.setBook(bookDto);
		loanDto.setUser(userDto);
		loanDto.setLoanStartedDate(loanUpdateRequest.getLoanStartedDate());
		loanDto.setLoanEndsDate(loanUpdateRequest.getLoanEndsDate());
		loanDto.setStatus(loanUpdateRequest.getStatus());
		
		return loanDto;
	}
}
