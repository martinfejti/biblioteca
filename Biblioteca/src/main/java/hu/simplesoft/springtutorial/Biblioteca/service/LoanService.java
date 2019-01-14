package hu.simplesoft.springtutorial.Biblioteca.service;

import java.util.List;

import hu.simplesoft.springtutorial.Biblioteca.service.exception.ServiceException;
import hu.simplesoft.sprintutorial.Biblioteca.service.dto.LoanDto;

public interface LoanService {

	void createLoan(LoanDto loanDto) throws ServiceException;
	void updateLoan(LoanDto loanDto) throws ServiceException;
	void deleteLoan(long loanId) throws ServiceException;
	LoanDto getLoanById(long loanId) throws ServiceException;
	List<LoanDto> getAllLoans() throws ServiceException;
}
