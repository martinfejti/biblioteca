package hu.simplesoft.springtutorial.Biblioteca.controller.request;

import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

@Validated
public class LoanCreateRequest {

	@Valid
	private long bookId;
	
	@Valid
	private long userId;
	
	@NotNull
	private Date loanStartedDate;
	
	private Date loanEndsDate;
	
	@Size(min = 5, max = 20, message = "The loan status should be between 5 and 20 characters!")
	private String status;
	
	public LoanCreateRequest() {
	}

	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
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
