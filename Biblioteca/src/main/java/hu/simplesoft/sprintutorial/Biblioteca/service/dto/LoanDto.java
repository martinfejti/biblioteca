package hu.simplesoft.sprintutorial.Biblioteca.service.dto;

import java.util.Date;

public class LoanDto {

	private BookDto book;
	private UserDto user;
	private Date loanStartedDate;
	private Date loanEndsDate;
	private String status;
	
	public LoanDto() {
		
	}

	public BookDto getBook() {
		return book;
	}

	public void setBook(BookDto book) {
		this.book = book;
	}

	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
		this.user = user;
	}

	public Date getLoanStartedDate() {
		return loanStartedDate;
	}

	public void setLoanStartedDate(Date loanStartedDate) {
		this.loanStartedDate = loanStartedDate;
	}

	public Date getLoanEndsDate() {
		return loanEndsDate;
	}

	public void setLoanEndsDate(Date loanEndsDate) {
		this.loanEndsDate = loanEndsDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
