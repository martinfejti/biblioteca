package hu.simplesoft.springtutorial.Biblioteca.data.dao.impl;

import java.util.List;

import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import hu.simplesoft.springtutorial.Biblioteca.data.dao.AddressDao;
import hu.simplesoft.springtutorial.Biblioteca.data.entity.AddressEntity;
import hu.simplesoft.springtutorial.Biblioteca.data.exception.ElementNotFoundException;
import hu.simplesoft.springtutorial.Biblioteca.data.exception.PersistenceException;
import hu.simplesoft.springtutorial.Biblioteca.data.mapper.AddressMapper;
import hu.simplesoft.springtutorial.Biblioteca.data.repository.AddressRepository;
import hu.simplesoft.sprintutorial.Biblioteca.service.dto.AddressDto;

@Component
public class AddressDaoImpl implements AddressDao{

	@PersistenceContext
	private AddressRepository addressRepository;
	
	public AddressDaoImpl() {
	}
	
	@Override
	public AddressDto getAddressById(long addressId) throws ElementNotFoundException{
		AddressEntity foundEntity;
		
		try {
			foundEntity = this.addressRepository.getAddressById(addressId);
		} catch (RuntimeException e) {
			throw new ElementNotFoundException("Element not found!", e);
		}
		
		return AddressMapper.convertEntityToDto(foundEntity);
	}
	
	@Override
	public List<AddressDto> getAllAddresses() throws ElementNotFoundException{
		List<AddressEntity> addressEntityList;
		
		try {
			addressEntityList = this.addressRepository.getAllAddresses();
		} catch (RuntimeException e) {
			throw new ElementNotFoundException("Element not found", e);
		}
		
		return AddressMapper.convertListEntityToDto(addressEntityList);
	}
	
	@Override
	public boolean createAddress(AddressDto addressDto) throws PersistenceException{
		boolean isSuccess = false;
		AddressEntity newAddressEntity = AddressMapper.convertDtoToEntity(addressDto);
		
		try {
			this.addressRepository.createAddress(newAddressEntity);
			isSuccess = true;
		} catch (RuntimeException e) {
			throw new PersistenceException("Create has failed!", e);
		}
		
		return isSuccess;
	}
	
	@Override
	public boolean updateAddress(AddressDto addressDto) throws PersistenceException {
		boolean isSuccess = false;
		AddressEntity addressEntityForUpdate = this.addressRepository.getAddressById(addressDto.getId());
		
		if(addressEntityForUpdate != null) {
			addressEntityForUpdate = updateAddressEntity(addressEntityForUpdate, addressDto);
			
			try {
				this.addressRepository.updateAddress(addressEntityForUpdate);
				isSuccess = true;
			} catch (RuntimeException e) {
				throw new PersistenceException("Update has failed", e);
			}
		}
		
		return isSuccess;
	}
	
	@Override
	public boolean deleteAddress(long addressId) throws PersistenceException{
		boolean isSuccess = false;
		AddressEntity addressEntityForDelete = this.addressRepository.getAddressById(addressId);
		
		try {
			this.addressRepository.deleteAddress(addressEntityForDelete);
			isSuccess = true;
		} catch (RuntimeException e) {
			throw new PersistenceException("Delete has failed!", e);
		}
		
		return isSuccess;
	}
	
	private AddressEntity updateAddressEntity(AddressEntity originalAddressEntity, AddressDto newAddressDto) {
		AddressEntity newAddressEntity = AddressMapper.convertDtoToEntity(newAddressDto);
		
		originalAddressEntity.setAddressId(newAddressEntity.getAddressId());
		originalAddressEntity.setCountry(newAddressEntity.getCountry());
		originalAddressEntity.setCity(newAddressEntity.getCity());
		originalAddressEntity.setStreet(newAddressEntity.getStreet());
		originalAddressEntity.setHouse_number(newAddressEntity.getHouseNumber());
		
		return originalAddressEntity;
	}
}
