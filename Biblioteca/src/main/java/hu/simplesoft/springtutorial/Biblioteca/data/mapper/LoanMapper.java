package hu.simplesoft.springtutorial.Biblioteca.data.mapper;

import org.mapstruct.Mapper;

import hu.simplesoft.springtutorial.Biblioteca.data.entity.LoanEntity;
import hu.simplesoft.sprintutorial.Biblioteca.service.dto.LoanDto;

@Mapper
public abstract class LoanMapper {

	public abstract LoanEntity mapLoanDtoToEntity(LoanDto loanDto);
	public abstract LoanDto mapLoanEntityToDto(LoanEntity loanEntity);
}
