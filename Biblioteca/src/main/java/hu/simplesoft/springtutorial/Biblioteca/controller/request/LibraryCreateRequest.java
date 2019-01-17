package hu.simplesoft.springtutorial.Biblioteca.controller.request;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

@Validated
public class LibraryCreateRequest {

	@NotNull
	@Size(min = 5, max = 30, message = "The name should be between 5 and 30 characters!")
	private String name;
	
	@Valid
	private long addressId;
	
	public LibraryCreateRequest(){
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getAddressCreateRequest() {
		return addressId;
	}

	public void setAddressCreateRequest(long addressId) {
		this.addressId = addressId;
	}
	
}
