package hu.simplesoft.springtutorial.Biblioteca.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.simplesoft.springtutorial.Biblioteca.data.dao.AddressDao;
import hu.simplesoft.springtutorial.Biblioteca.data.exception.ElementNotFoundException;
import hu.simplesoft.springtutorial.Biblioteca.data.exception.ObjectIsNullException;
import hu.simplesoft.springtutorial.Biblioteca.data.exception.PersistenceException;
import hu.simplesoft.springtutorial.Biblioteca.service.AddressService;
import hu.simplesoft.sprintutorial.Biblioteca.service.dto.AddressDto;

@Service
public class AddressServiceImpl implements AddressService{

	@Autowired
	private AddressDao addressDao;
	
	@Override
	public void createAddress(AddressDto addressDto) throws PersistenceException{
		this.addressDao.createAddress(addressDto);
	}
	
	@Override
	public void updateAddress(AddressDto addressDto) throws PersistenceException, ObjectIsNullException{
		this.addressDao.updateAddress(addressDto);
	}
	
	@Override
	public void deleteAddress(long addressId) throws PersistenceException, ObjectIsNullException{
		this.addressDao.deleteAddress(addressId);
	}
	
	@Override
	public AddressDto getAddressById(long addressId) throws ElementNotFoundException, ObjectIsNullException{
		return this.addressDao.getAddressById(addressId);
	}
	
	@Override
	public List<AddressDto> getAllAddresses() throws ElementNotFoundException{
		return this.addressDao.getAllAddresses();
	}
}
