package hu.simplesoft.springtutorial.Biblioteca.data.repository;

import java.util.List;

import hu.simplesoft.springtutorial.Biblioteca.data.entity.LoanEntity;
import hu.simplesoft.springtutorial.Biblioteca.data.exception.PersistenceException;

public interface LoanRepository {

	void createLoan(LoanEntity loanEntity) throws PersistenceException;
	void updateLoan(LoanEntity loanEntity) throws PersistenceException;
	void deleteLoan(LoanEntity loanEntity) throws PersistenceException;
	LoanEntity getLoanById(long loanId) throws PersistenceException;
	List<LoanEntity> getAllLoans() throws PersistenceException;
	
}
