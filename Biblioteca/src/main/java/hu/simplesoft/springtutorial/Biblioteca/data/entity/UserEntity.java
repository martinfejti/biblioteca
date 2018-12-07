package hu.simplesoft.springtutorial.Biblioteca.data.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

@Entity(name = "user")
@Table(name = "user")
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private long userId;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "role_id")
	private RoleEntity role;
	
	@NonNull
	@Column(name = "username")
	private String username;
	
	@NonNull
	@Column(name = "email")
	private String email;
	
	@NonNull
	@Column(name = "password")
	private String password;
	
	@Column(name = "birth_date")
	private Date birthDate;
	
	@Column(name = "nationality")
	private String nationality;
	
	@NonNull
	@Column(name = "name")
	private String name;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "address_id")
	private AddressEntity address;
	
	public UserEntity() {
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public RoleEntity getRole() {
		return role;
	}

	public void setRole(RoleEntity role) {
		this.role = role;
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

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
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
