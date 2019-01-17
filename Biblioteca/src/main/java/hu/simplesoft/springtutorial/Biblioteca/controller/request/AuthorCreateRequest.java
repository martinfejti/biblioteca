package hu.simplesoft.springtutorial.Biblioteca.controller.request;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

@Validated
public class AuthorCreateRequest {

	@NotNull
	@Size(min = 5, max = 40, message = "The name should be between 5 and 40 characters!")
	private String name;
	
	private Date birthdate;
	
	@NotNull
	@Size(min = 2, max = 50, message = "The birthplace should be between 2 and 50 charackters!")
	private String birthplace;
	
	@NotNull
	@Size(min = 4, max = 30, message = "The nationality should be between 4 and 30 characters!")
	private String nationality;
	
	public AuthorCreateRequest() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getBirthplace() {
		return birthplace;
	}

	public void setBirthplace(String birthplace) {
		this.birthplace = birthplace;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
	
}
