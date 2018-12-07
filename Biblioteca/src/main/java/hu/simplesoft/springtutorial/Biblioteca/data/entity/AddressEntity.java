package hu.simplesoft.springtutorial.Biblioteca.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

@Entity(name="address")
@Table(name="address")
public class AddressEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "address_id")
	private long addressId;
	
	@NonNull
	@Column(name = "country")
	private String country;
	
	@NonNull
	@Column(name = "city")
	private String city;
	
	@NonNull
	@Column(name = "street")
	private String street;
	
	@NonNull
	@Column(name = "house_number")
	private String houseNumber;
	
	public AddressEntity() {
		
	}

	public long getAddressId() {
		return addressId;
	}

	public void setAddressId(long addressId) {
		this.addressId = addressId;
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

	public void setHouse_number(String houseNumber) {
		this.houseNumber = houseNumber;
	}
	
}
