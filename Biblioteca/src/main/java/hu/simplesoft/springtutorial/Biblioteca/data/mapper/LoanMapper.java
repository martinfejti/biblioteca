package hu.simplesoft.springtutorial.Biblioteca.data.mapper;


import hu.simplesoft.springtutorial.Biblioteca.data.entity.LoanEntity;
import hu.simplesoft.sprintutorial.Biblioteca.service.dto.LoanDto;

public final class LoanMapper {

	private LoanMapper() {
		
	}
	
	public static LoanEntity convertLoanDtoToEntity(LoanDto loanDto) {
		LoanEntity loanEntity = new LoanEntity();
		
		loanEntity.setLoanId(loanDto.getId());
		loanEntity.setBook(BookMapper.convertDtoToEntity(loanDto.getBook()));
		loanEntity.setUser(UserMapper.convertDtoToEntity(loanDto.getUser()));
		loanEntity.setLoanStartedDate(loanDto.getLoanStartedDate());
		loanEntity.setLoanEndsDate(loanDto.getLoanEndsDate());
		loanEntity.setStatus(loanDto.getStatus());
		
		return loanEntity;
	}
	
	public static LoanDto convertEntityToDto(LoanEntity loanEntity) {
		LoanDto loanDto = new LoanDto();
		
		loanDto.setId(loanEntity.getLoanId());
		loanDto.setBook(BookMapper.convertEntityToDto(loanEntity.getBook()));
		loanDto.setUser(UserMapper.convertEntityToDto(loanEntity.getUser()));
		loanDto.setLoanStartedDate(loanEntity.getLoanStartedDate());
		loanDto.setLoanEndsDate(loanEntity.getLoanEndsDate());
		loanDto.setStatus(loanEntity.getStatus());
		
		return loanDto;
	}
}
