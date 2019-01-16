package hu.simplesoft.springtutorial.Biblioteca.controller.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class AddressUpdateRequest extends AddressCreateRequest{

	@NotNull
	@Positive
	private long id;
	
	public AddressUpdateRequest() {
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
}
