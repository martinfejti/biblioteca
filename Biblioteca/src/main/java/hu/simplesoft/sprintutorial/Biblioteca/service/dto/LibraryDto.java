package hu.simplesoft.sprintutorial.Biblioteca.service.dto;

public class LibraryDto {

	private String name;
	private AddressDto address;
	
	public LibraryDto() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AddressDto getAddress() {
		return address;
	}

	public void setAddress(AddressDto address) {
		this.address = address;
	}
	
	
}
