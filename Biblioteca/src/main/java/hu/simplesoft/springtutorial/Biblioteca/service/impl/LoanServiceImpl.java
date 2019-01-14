package hu.simplesoft.springtutorial.Biblioteca.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.simplesoft.springtutorial.Biblioteca.data.dao.LoanDao;
import hu.simplesoft.springtutorial.Biblioteca.data.exception.PersistenceException;
import hu.simplesoft.springtutorial.Biblioteca.service.LoanService;
import hu.simplesoft.springtutorial.Biblioteca.service.exception.ServiceException;
import hu.simplesoft.sprintutorial.Biblioteca.service.dto.LoanDto;

@Service
public class LoanServiceImpl implements LoanService{
 
	@Autowired
	private LoanDao loanDao;
	
	@Override
	public void createLoan(LoanDto loanDto) throws ServiceException{
		try {
			this.loanDao.createLoan(loanDto);
		} catch (PersistenceException e) { 
			throw new ServiceException("Element not found!", e);
		}
	}
	
	@Override
	public void updateLoan(LoanDto loanDto) throws ServiceException{
		try {
			this.loanDao.updateLoan(loanDto);
		} catch (PersistenceException e) {
			throw new ServiceException("Update has failed!", e);
		}
	}
	
	@Override
	public void deleteLoan(long loanId) throws ServiceException{
		try {
			this.loanDao.deleteLoan(loanId);
		} catch (PersistenceException e) {
			throw new ServiceException("Delete has failed!", e);
		}
	}
	
	@Override
	public LoanDto getLoanById(long loanId) throws ServiceException{
		try {
			return this.loanDao.getLoanById(loanId);
		} catch (PersistenceException e) {
			throw new ServiceException("Element not found!", e);
		}
	}
	
	@Override
	public List<LoanDto> getAllLoans() throws ServiceException{
		try {
			return this.loanDao.getAllLoans();
		} catch (PersistenceException e) {
			throw new ServiceException("Element not found!", e);
		}
	}
}
