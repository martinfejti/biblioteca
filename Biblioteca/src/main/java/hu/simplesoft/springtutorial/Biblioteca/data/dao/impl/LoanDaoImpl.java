package hu.simplesoft.springtutorial.Biblioteca.data.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import hu.simplesoft.springtutorial.Biblioteca.data.dao.LoanDao;
import hu.simplesoft.springtutorial.Biblioteca.data.entity.LoanEntity;
import hu.simplesoft.springtutorial.Biblioteca.data.exception.ElementNotFoundException;
import hu.simplesoft.springtutorial.Biblioteca.data.exception.PersistenceException;
import hu.simplesoft.springtutorial.Biblioteca.data.mapper.LoanMapper;
import hu.simplesoft.springtutorial.Biblioteca.data.repository.LoanRepository;
import hu.simplesoft.sprintutorial.Biblioteca.service.dto.LoanDto;

@Component
public class LoanDaoImpl implements LoanDao{

	private LoanRepository loanRepository;
	
	@Override
	public LoanDto getLoanById(long loanId) throws ElementNotFoundException{
		LoanEntity loanEntity = this.loanRepository.getLoanById(loanId);
		
		return LoanMapper.convertEntityToDto(loanEntity);
	}
	
	@Override
	public List<LoanDto> getAllLoans() throws ElementNotFoundException{
		List<LoanEntity> loanEntityList = this.loanRepository.getAllLoans();
		
		return LoanMapper.convertListEntityToDto(loanEntityList);
	}
	
	@Override
	public void createLoan(LoanDto loanDto) throws PersistenceException{
		LoanEntity newLoanEntity = LoanMapper.convertLoanDtoToEntity(loanDto);
		
		this.loanRepository.createLoan(newLoanEntity);
	}
	
	@Override
	public void updateLoan(LoanDto loanDto) throws PersistenceException{
		LoanEntity loanEntityForUpdate = this.loanRepository.getLoanById(loanDto.getId());
		
		if(loanEntityForUpdate != null) {
			loanEntityForUpdate = updateLoanEntity(loanEntityForUpdate, loanDto);
			
			this.loanRepository.updateLoan(loanEntityForUpdate);
		}
	}
	
	@Override
	public void deleteLoan(long loanId) throws PersistenceException{
		LoanEntity loanEntityForDelete = this.loanRepository.getLoanById(loanId);

		this.loanRepository.deleteLoan(loanEntityForDelete);
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
