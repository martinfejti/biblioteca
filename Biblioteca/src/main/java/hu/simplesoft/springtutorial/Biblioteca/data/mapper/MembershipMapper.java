package hu.simplesoft.springtutorial.Biblioteca.data.mapper;

import org.mapstruct.Mapper;

import hu.simplesoft.springtutorial.Biblioteca.data.entity.MembershipEntity;
import hu.simplesoft.sprintutorial.Biblioteca.service.dto.MembershipDto;

@Mapper
public abstract class MembershipMapper {

	public abstract MembershipEntity mapMembershipDtoToEntity(MembershipDto membershipDto);
	public abstract MembershipDto mapMembershipEntityToDto(MembershipEntity membershipEntity);
}
