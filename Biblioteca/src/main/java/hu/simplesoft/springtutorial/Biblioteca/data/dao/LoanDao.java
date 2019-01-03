package hu.simplesoft.springtutorial.Biblioteca.data.dao;

import hu.simplesoft.sprintutorial.Biblioteca.service.dto.LoanDto;

public interface LoanDao {

	boolean createLoan(LoanDto loanDto);
	boolean updateLoan(LoanDto loanDto);
	boolean deleteLoan(long loanId);
	LoanDto getLoanById(long loanId);
}
