package hu.simplesoft.springtutorial.Biblioteca.controller.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

@Validated
public class RoleCreateRequest {

	@NotNull
	@Size(min = 4, max = 20, message = "The role name should be between 4 and 20 characters!")
	private String name;
	
	public RoleCreateRequest() {
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
