package hu.simplesoft.springtutorial.Biblioteca.data.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import hu.simplesoft.springtutorial.Biblioteca.data.dao.AddressDao;
import hu.simplesoft.springtutorial.Biblioteca.data.entity.AddressEntity;
import hu.simplesoft.springtutorial.Biblioteca.data.mapper.AddressMapper;
import hu.simplesoft.springtutorial.Biblioteca.data.util.Constants;
import hu.simplesoft.sprintutorial.Biblioteca.service.dto.AddressDto;

@Repository
@Transactional
public class AddressDaoImpl implements AddressDao{

	private static final Logger LOGGER = LogManager.getLogger(AddressDaoImpl.class);
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public AddressDaoImpl() {
		
	}
	
	@Override
	public AddressDto getAddressById(long addressId) {
		AddressEntity foundEntity = this.entityManager.find(AddressEntity.class, addressId);
		
		return AddressMapper.convertEntityToDto(foundEntity);
	}
	
	@Override
	public boolean createAddress(AddressDto addressDto) {
		boolean isSuccess = false;
		AddressEntity newAddressEntity = AddressMapper.convertDtoToEntity(addressDto);
		
		try {
			this.entityManager.persist(newAddressEntity);
			isSuccess = true;
		} catch (RuntimeException e){
			LOGGER.error(Constants.AddressDaoErrorLogMessages.CREATE_FAILED,e);
		}
		
		return isSuccess;
	}
	
	@Override
	public boolean updateAddress(AddressDto addressDto) {
		boolean isSuccess = false;
		AddressEntity addressEntityForUpdate = entityManager.find(AddressEntity.class, addressDto.getId());
		
		if(addressEntityForUpdate != null) {
			addressEntityForUpdate = updateAddressEntity(addressEntityForUpdate, addressDto);
			
			try {
				this.entityManager.persist(addressEntityForUpdate);
				isSuccess = true;
			} catch (RuntimeException e) {
				LOGGER.error(Constants.AddressDaoErrorLogMessages.UPDATE_FAILED,e);
			}
		}
		
		return isSuccess;
	}
	
	@Override
	public boolean deleteAddress(long addressId) {
		boolean isSuccess = false;
		AddressEntity addressEntityForDelete = entityManager.find(AddressEntity.class, addressId);
		
		try {
			this.entityManager.remove(addressEntityForDelete);
			isSuccess = true;
		} catch (RuntimeException e) {
			LOGGER.error(Constants.AddressDaoErrorLogMessages.DELETE_FAILED,e);
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
