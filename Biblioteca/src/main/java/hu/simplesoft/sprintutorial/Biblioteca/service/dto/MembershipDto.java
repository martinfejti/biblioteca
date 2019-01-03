package hu.simplesoft.sprintutorial.Biblioteca.service.dto;

import java.util.Date;

public class MembershipDto {

	private UserDto user;
	private LibraryDto library;
	private Date beginningOfMembership;
	
	public MembershipDto() {
		
	}

	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
		this.user = user;
	}

	public LibraryDto getLibrary() {
		return library;
	}

	public void setLibrary(LibraryDto library) {
		this.library = library;
	}

	public Date getBeginningOfMembership() {
		return beginningOfMembership;
	}

	public void setBeginningOfMembership(Date beginningOfMembership) {
		this.beginningOfMembership = beginningOfMembership;
	}
	
	
}
