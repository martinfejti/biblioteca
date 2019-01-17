package hu.simplesoft.springtutorial.Biblioteca.controller.request;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

@Validated
public class MembershipCreateRequest {

	
	@Valid
	private long userId;
	
	@Valid 
	private long libraryId;
	
	private Date beginningOfMembershipDate;
	
	public MembershipCreateRequest() {
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getLibraryId() {
		return libraryId;
	}

	public void setLibraryId(long libraryId) {
		this.libraryId = libraryId;
	}

	public Date getBeginningOfMembershipDate() {
		return beginningOfMembershipDate;
	}

	public void setBeginningOfMembershipDate(Date beginningOfMembershipDate) {
		this.beginningOfMembershipDate = beginningOfMembershipDate;
	}
	
}
