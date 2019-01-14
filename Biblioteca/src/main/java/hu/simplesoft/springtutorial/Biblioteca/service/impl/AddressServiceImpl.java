package hu.simplesoft.springtutorial.Biblioteca.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.simplesoft.springtutorial.Biblioteca.data.dao.AddressDao;
import hu.simplesoft.springtutorial.Biblioteca.data.exception.ObjectIsNullException;
import hu.simplesoft.springtutorial.Biblioteca.data.exception.PersistenceException;
import hu.simplesoft.springtutorial.Biblioteca.service.AddressService;
import hu.simplesoft.springtutorial.Biblioteca.service.exception.ServiceException;
import hu.simplesoft.sprintutorial.Biblioteca.service.dto.AddressDto;

@Service
public class AddressServiceImpl implements AddressService{

	@Autowired
	private AddressDao addressDao;
	
	@Override
	public void createAddress(AddressDto addressDto) throws ServiceException{
		try {
			this.addressDao.createAddress(addressDto);
		} catch (PersistenceException e) {
			throw new ServiceException("Create has failed!", e);
		}
	}
	
	@Override
	public void updateAddress(AddressDto addressDto) throws ServiceException, ObjectIsNullException{
		try {
			this.addressDao.updateAddress(addressDto);
		} catch (PersistenceException e) {
			throw new ServiceException("Update has failed!", e);
		}
	}
	
	@Override
	public void deleteAddress(long addressId) throws ServiceException, ObjectIsNullException{
		try {
			this.addressDao.deleteAddress(addressId);
		} catch (PersistenceException e) {
			throw new ServiceException("Delete has failed!", e);
		}
	}
	
	@Override
	public AddressDto getAddressById(long addressId) throws ServiceException, ObjectIsNullException{
		try {
			return this.addressDao.getAddressById(addressId);
		} catch (PersistenceException e) {
			throw new ServiceException("Element not found!", e);
		}
	}
	
	@Override
	public List<AddressDto> getAllAddresses() throws ServiceException{
		try { 
			return this.addressDao.getAllAddresses();
		} catch (PersistenceException e) {
			throw new ServiceException("Element not found!", e);
		}
	}
}
