package hu.simplesoft.springtutorial.Biblioteca.data.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hu.simplesoft.springtutorial.Biblioteca.data.dao.AddressDao;
import hu.simplesoft.springtutorial.Biblioteca.data.entity.AddressEntity;
import hu.simplesoft.springtutorial.Biblioteca.data.exception.ElementNotFoundException;
import hu.simplesoft.springtutorial.Biblioteca.data.exception.ObjectIsNullException;
import hu.simplesoft.springtutorial.Biblioteca.data.exception.PersistenceException;
import hu.simplesoft.springtutorial.Biblioteca.data.mapper.AddressMapper;
import hu.simplesoft.springtutorial.Biblioteca.data.repository.AddressRepository;
import hu.simplesoft.springtutorial.Biblioteca.data.util.Validator;
import hu.simplesoft.sprintutorial.Biblioteca.service.dto.AddressDto;

@Component
public class AddressDaoImpl implements AddressDao{

	@Autowired
	private AddressRepository addressRepository;
	
	public AddressDaoImpl() {
	}
	
	@Override
	public AddressDto getAddressById(long addressId) throws ElementNotFoundException, ObjectIsNullException{
		AddressEntity foundEntity = this.addressRepository.getAddressById(addressId);
		
		Validator.validateObject(foundEntity, addressId);
		
		return AddressMapper.convertEntityToDto(foundEntity);
	}
	
	@Override
	public List<AddressDto> getAllAddresses() throws ElementNotFoundException{
		List<AddressEntity> addressEntityList = this.addressRepository.getAllAddresses();
		
		return AddressMapper.convertListEntityToDto(addressEntityList);
	}
	
	@Override
	public void createAddress(AddressDto addressDto) throws PersistenceException{
		AddressEntity newAddressEntity = AddressMapper.convertDtoToEntity(addressDto);
		
		this.addressRepository.createAddress(newAddressEntity);
		
	}
	
	@Override
	public void updateAddress(AddressDto addressDto) throws PersistenceException, ObjectIsNullException{
		AddressEntity addressEntityForUpdate = this.addressRepository.getAddressById(addressDto.getId());
		
		Validator.validateObject(addressEntityForUpdate, addressDto.getId());
		
		addressEntityForUpdate = updateAddressEntity(addressEntityForUpdate, addressDto);
		
		this.addressRepository.updateAddress(addressEntityForUpdate);
	}
	
	@Override
	public void deleteAddress(long addressId) throws PersistenceException, ObjectIsNullException{
		AddressEntity addressEntityForDelete = this.addressRepository.getAddressById(addressId);
		
		Validator.validateObject(addressEntityForDelete, addressId);
		
		this.addressRepository.deleteAddress(addressEntityForDelete);
		
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
