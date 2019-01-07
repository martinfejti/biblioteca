package hu.simplesoft.springtutorial.Biblioteca.data.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import hu.simplesoft.springtutorial.Biblioteca.data.dao.LoanDao;
import hu.simplesoft.springtutorial.Biblioteca.data.entity.LoanEntity;
import hu.simplesoft.springtutorial.Biblioteca.data.mapper.LoanMapper;
import hu.simplesoft.sprintutorial.Biblioteca.service.dto.LoanDto;

@Repository
@Transactional
public class LoanDaoImpl implements LoanDao{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public LoanDto getLoanById(long loanId) {
		LoanEntity loanEntity = entityManager.find(LoanEntity.class, loanId);
		
		return LoanMapper.convertEntityToDto(loanEntity);
	}
	
	@Override
	public boolean createLoan(LoanDto loanDto) {
		boolean isSuccess = false;
		LoanEntity newLoanEntity = LoanMapper.convertLoanDtoToEntity(loanDto);
		
		try {
			this.entityManager.persist(newLoanEntity);
			isSuccess = true;
		} catch (RuntimeException e) {
		}
		
		return isSuccess;
	}
	
	@Override
	public boolean updateLoan(LoanDto loanDto) {
		boolean isSuccess = false;
		LoanEntity loanEntityForUpdate = entityManager.find(LoanEntity.class, loanDto.getId());
		
		if(loanEntityForUpdate != null) {
			loanEntityForUpdate = updateLoanEntity(loanEntityForUpdate, loanDto);
			
			try {
				this.entityManager.merge(loanEntityForUpdate);
				isSuccess = true;
			} catch (RuntimeException e) {
			}
			
		}
		
		return isSuccess;
	}
	
	@Override
	public boolean deleteLoan(long loanId) {
		boolean isSuccess = false;
		LoanEntity loanEntityForDelete = entityManager.find(LoanEntity.class, loanId);
		
		try {
			this.entityManager.remove(loanEntityForDelete);
			isSuccess = true;
		} catch(RuntimeException e) {
		}
		
		return isSuccess;
	}
	
	public LoanEntity updateLoanEntity(LoanEntity originalLoanEntity, LoanDto newLoanDto) {
		LoanEntity newLoanEntity = LoanMapper.convertLoanDtoToEntity(newLoanDto);
		
		originalLoanEntity.setLoanId(newLoanEntity.getLoanId());
		originalLoanEntity.setBook(newLoanEntity.getBook());
		originalLoanEntity.setUser(newLoanEntity.getUser());
		originalLoanEntity.setLoanStartedDate(newLoanEntity.getLoanStartedDate());
		originalLoanEntity.setLoanEndsDate(newLoanEntity.getLoanEndsDate());
		originalLoanEntity.setStatus(newLoanEntity.getStatus());
		
		return originalLoanEntity;
	}
}
