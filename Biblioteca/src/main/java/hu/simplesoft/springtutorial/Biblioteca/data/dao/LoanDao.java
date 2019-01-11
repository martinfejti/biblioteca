package hu.simplesoft.springtutorial.Biblioteca.data.dao;

import java.util.List;

import hu.simplesoft.springtutorial.Biblioteca.data.exception.ElementNotFoundException;
import hu.simplesoft.springtutorial.Biblioteca.data.exception.ObjectIsNullException;
import hu.simplesoft.springtutorial.Biblioteca.data.exception.PersistenceException;
import hu.simplesoft.sprintutorial.Biblioteca.service.dto.LoanDto;

public interface LoanDao {

	void createLoan(LoanDto loanDto) throws PersistenceException;
	void updateLoan(LoanDto loanDto) throws PersistenceException, ObjectIsNullException;
	void deleteLoan(long loanId) throws PersistenceException, ObjectIsNullException;
	LoanDto getLoanById(long loanId) throws ElementNotFoundException, ObjectIsNullException;
	List<LoanDto> getAllLoans() throws ElementNotFoundException;
}
