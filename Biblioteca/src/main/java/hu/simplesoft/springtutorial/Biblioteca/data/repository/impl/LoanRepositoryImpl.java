package hu.simplesoft.springtutorial.Biblioteca.data.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import hu.simplesoft.springtutorial.Biblioteca.data.entity.LoanEntity;
import hu.simplesoft.springtutorial.Biblioteca.data.exception.ElementNotFoundException;
import hu.simplesoft.springtutorial.Biblioteca.data.exception.PersistenceException;
import hu.simplesoft.springtutorial.Biblioteca.data.repository.LoanRepository;

@Repository
@Transactional
public class LoanRepositoryImpl implements LoanRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	public LoanRepositoryImpl() {
	}
	
	@Override
	public LoanEntity getLoanById(long loanId) throws PersistenceException{
		LoanEntity loanEntity;
		
		try {
			loanEntity = this.entityManager.find(LoanEntity.class, loanId);
		} catch (RuntimeException e) {
			throw new ElementNotFoundException("Element not found!", e);
		}
		return loanEntity;
	}
	
	@Override
	public List<LoanEntity> getAllLoans() throws PersistenceException{
		List<LoanEntity> loanEntityList;
		
		try {
			TypedQuery<LoanEntity> query = this.entityManager.createQuery("SELECT l FROM Loan l", LoanEntity.class);
			loanEntityList = query.getResultList();
		} catch (RuntimeException e) {
			throw new ElementNotFoundException("Element not found!", e);
		}
		
		return loanEntityList;
	}
	
	@Override
	public void createLoan(LoanEntity loanEntity) throws PersistenceException{
		
		try {
			this.entityManager.persist(loanEntity);
		} catch (RuntimeException e) {
			throw new PersistenceException("Create has failed!", e);
		}
	}
	
	@Override
	public void updateLoan(LoanEntity loanEntity) throws PersistenceException{
		
		try {
			this.entityManager.merge(loanEntity);
		} catch (RuntimeException e) {
			throw new PersistenceException("Update has failed!", e);
		}
	}
	
	@Override
	public void deleteLoan(LoanEntity loanEntity) throws PersistenceException{
		
		try {
			this.entityManager.remove(loanEntity);
		} catch (RuntimeException e) {
			throw new PersistenceException("Delete has failed!", e);
		}
	}
}
