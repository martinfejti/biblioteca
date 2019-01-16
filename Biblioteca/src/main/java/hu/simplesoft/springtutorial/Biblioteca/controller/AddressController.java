package hu.simplesoft.springtutorial.Biblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hu.simplesoft.springtutorial.Biblioteca.service.AddressService;
import hu.simplesoft.springtutorial.Biblioteca.service.exception.ServiceException;
import hu.simplesoft.sprintutorial.Biblioteca.service.dto.AddressDto;

@RestController
@RequestMapping("/address")
public class AddressController {

	@Autowired
	private AddressService addressService;
	
	@PostMapping("/createAddress")
	public void createAddress(@RequestBody AddressDto addressDto) throws ServiceException{
		this.addressService.createAddress(addressDto);
	}
	
	@PutMapping("/updateAddress")
	public void updateAddress(@RequestBody AddressDto addressDto) throws ServiceException{
		this.addressService.updateAddress(addressDto);
	}
	
	@DeleteMapping("/deleteAddress/{id}")
	public void deleteAddress(@PathVariable long id) throws ServiceException{
		this.addressService.deleteAddress(id);
	}
	
	@GetMapping("/getAddress/{id}")
	public AddressDto getAddressById(@PathVariable long id) throws ServiceException{
		AddressDto addressDto = this.addressService.getAddressById(id);
		return addressDto;
	}
	
	@GetMapping("/getAllAddresses")
	public List<AddressDto> getAllTickets() throws ServiceException{
		List<AddressDto> addressDtoList = this.addressService.getAllAddresses();
		return addressDtoList;
	}
}
