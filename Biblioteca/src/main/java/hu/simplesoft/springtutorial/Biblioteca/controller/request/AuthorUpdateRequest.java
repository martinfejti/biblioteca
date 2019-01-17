package hu.simplesoft.springtutorial.Biblioteca.controller.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.validation.annotation.Validated;

@Validated
public class AuthorUpdateRequest extends AuthorCreateRequest{

	@NotNull
	@Positive
	private long id;
	
	public AuthorUpdateRequest() {
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
}
