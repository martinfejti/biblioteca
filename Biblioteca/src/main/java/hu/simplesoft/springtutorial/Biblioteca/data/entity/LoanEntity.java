package hu.simplesoft.springtutorial.Biblioteca.data.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

@Entity(name = "loan")
@Table(name = "loan")
public class LoanEntity {

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "book_id")
	private BookEntity book;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private UserEntity user;
	
	@NonNull
	@Column(name = "loan_started_date")
	private Date loanStartedDate;
	
	@Column(name = "loan_ends_date")
	private Date loanEndsDate;
	
	@Column(name = "loan_status")
	private String status;
	
	public LoanEntity() {
		
	}

	public BookEntity getBook() {
		return book;
	}

	public void setBook(BookEntity book) {
		this.book = book;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
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
