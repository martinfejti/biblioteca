package hu.simplesoft.springtutorial.Biblioteca.controller.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

@Validated
public class AddressCreateRequest {

	@NotNull
	@Size(min = 3, max = 30, message = "The country name should be between 3 and 30 characters!")
	private String country;
	
	@NotNull
	@Size(min = 2, max = 30, message = "The city name should be between 2 and 30 characters!")
	private String city;
	
	@NotNull
	@Size(min = 5, max = 50, message = "The street name should be between 5 and 50 characters")
	private String street;
	
	@NotNull
	@Size(min = 1, max = 10, message = "The house number should be between 1 and 10 characters!")
	private String houseNumber;
	
	public AddressCreateRequest() {
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}
	
	
}
