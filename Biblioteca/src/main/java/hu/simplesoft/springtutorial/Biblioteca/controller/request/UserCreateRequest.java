package hu.simplesoft.springtutorial.Biblioteca.controller.request;

import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

@Validated
public class UserCreateRequest {

	@Valid
	private long roleId;
	
	@NotNull
	@Size(min = 8, max = 30, message = "The username should be between 8 and 30 characters!")
	private String username;
	
	@NotNull
	@Email
	private String email;
	
	@NotNull
	@Size(min = 8, max = 20, message = "The password should be between 8 and 20 characters!")
	private String password;
	
	private Date birthdate;
	
	@Size(min = 4, max = 30, message = "The nationality should be between 4 and 30 characters!")
	private String nationality;
	
	@NotNull
	@Size(min = 5, max = 50, message = "The real name should be between 5 and 50 characters!")
	private String realName;
	
	@Valid
	private long addressId;
	
	public UserCreateRequest() {
	}

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public long getAddressId() {
		return addressId;
	}

	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}
	
}
