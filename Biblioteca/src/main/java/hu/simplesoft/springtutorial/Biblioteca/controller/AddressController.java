package hu.simplesoft.springtutorial.Biblioteca.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hu.simplesoft.springtutorial.Biblioteca.controller.request.AddressCreateRequest;
import hu.simplesoft.springtutorial.Biblioteca.controller.request.AddressUpdateRequest;
import hu.simplesoft.springtutorial.Biblioteca.controller.request.mapper.AddressRequestMapper;
import hu.simplesoft.springtutorial.Biblioteca.service.AddressService;
import hu.simplesoft.springtutorial.Biblioteca.service.exception.ServiceException;
import hu.simplesoft.sprintutorial.Biblioteca.service.dto.AddressDto;

@RestController
@RequestMapping("/address")
public class AddressController {

	@Autowired
	private AddressService addressService;
	
	@PostMapping("/createAddress")
	public void createAddress(@Valid @RequestBody AddressCreateRequest addressCreateRequest) throws ServiceException{
		AddressDto addressDtoToConvert = AddressRequestMapper.convertCreateRequestToDto(addressCreateRequest);
		this.addressService.createAddress(addressDtoToConvert);
	}
	
	@PutMapping("/updateAddress")
	public void updateAddress(@Valid @RequestBody AddressUpdateRequest addressUpdateRequest) throws ServiceException{
		AddressDto addressDtoToConvert = AddressRequestMapper.convertUpdateRequestToDto(addressUpdateRequest);
		this.addressService.updateAddress(addressDtoToConvert);
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
