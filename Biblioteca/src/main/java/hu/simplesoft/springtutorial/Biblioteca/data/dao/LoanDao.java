package hu.simplesoft.springtutorial.Biblioteca.data.dao;

import java.util.List;

import hu.simplesoft.springtutorial.Biblioteca.data.exception.ElementNotFoundException;
import hu.simplesoft.springtutorial.Biblioteca.data.exception.PersistenceException;
import hu.simplesoft.sprintutorial.Biblioteca.service.dto.LoanDto;

public interface LoanDao {

	void createLoan(LoanDto loanDto) throws PersistenceException;
	void updateLoan(LoanDto loanDto) throws PersistenceException;
	void deleteLoan(long loanId) throws PersistenceException;
	LoanDto getLoanById(long loanId) throws ElementNotFoundException;
	List<LoanDto> getAllLoans() throws ElementNotFoundException;
}
