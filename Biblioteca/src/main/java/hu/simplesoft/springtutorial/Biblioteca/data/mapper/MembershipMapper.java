package hu.simplesoft.springtutorial.Biblioteca.data.mapper;


import hu.simplesoft.springtutorial.Biblioteca.data.entity.MembershipEntity;
import hu.simplesoft.sprintutorial.Biblioteca.service.dto.MembershipDto;

public final class MembershipMapper {

	private MembershipMapper() {
		
	}
	
	public static MembershipEntity convertDtoToEntity(MembershipDto membershipDto) {
		MembershipEntity membershipEntity = new MembershipEntity();
		
		membershipEntity.setMembershipId(membershipDto.getId());
		membershipEntity.setBeginningOfMembership(membershipDto.getBeginningOfMembership());
		membershipEntity.setUser(UserMapper.convertDtoToEntity(membershipDto.getUser()));
		membershipEntity.setLibrary(LibraryMapper.convertDtoToEntity(membershipDto.getLibrary()));
		
		return membershipEntity;
	}
	
	public static MembershipDto convertEntityToDto(MembershipEntity membershipEntity) {
		MembershipDto membershipDto = new MembershipDto();
		
		membershipDto.setId(membershipEntity.getMembershipId());
		membershipDto.setBeginningOfMembership(membershipEntity.getBeginningOfMembership());
		membershipDto.setUser(UserMapper.convertEntityToDto(membershipEntity.getUser()));
		membershipDto.setLibrary(LibraryMapper.convertEntityToDto(membershipEntity.getLibrary()));
		
		return membershipDto;
	}
}
