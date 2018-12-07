package hu.simplesoft.springtutorial.Biblioteca.data.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity(name = "membership")
@Table(name = "membership")
public class MembershipEntity {

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private UserEntity user;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "library_id")
	private LibraryEntity library;
	
	@Column(name = "beginning_of_membership")
	private Date beginningOfMembership;
	
	public MembershipEntity() {
		
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public LibraryEntity getLibrary() {
		return library;
	}

	public void setLibrary(LibraryEntity library) {
		this.library = library;
	}

	public Date getBeginningOfMembership() {
		return beginningOfMembership;
	}

	public void setBeginningOfMembership(Date beginningOfMembership) {
		this.beginningOfMembership = beginningOfMembership;
	}
	
	
}
