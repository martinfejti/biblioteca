package hu.simplesoft.springtutorial.Biblioteca.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity(name = "library")
@Table(name = "library")
public class LibraryEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "library_id")
	private long libraryId;
	
	@NotNull
	@Column(name = "name")
	private String name;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "address_id")
	private AddressEntity address;
	
	public LibraryEntity() {
		
	}

	public long getLibraryId() {
		return libraryId;
	}

	public void setLibraryId(long libraryId) {
		this.libraryId = libraryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AddressEntity getAddress() {
		return address;
	}

	public void setAddress(AddressEntity address) {
		this.address = address;
	}
	
}
