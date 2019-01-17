package hu.simplesoft.springtutorial.Biblioteca.controller.mapper;

import hu.simplesoft.springtutorial.Biblioteca.controller.request.MembershipCreateRequest;
import hu.simplesoft.springtutorial.Biblioteca.controller.request.MembershipUpdateRequest;
import hu.simplesoft.sprintutorial.Biblioteca.service.dto.LibraryDto;
import hu.simplesoft.sprintutorial.Biblioteca.service.dto.MembershipDto;
import hu.simplesoft.sprintutorial.Biblioteca.service.dto.UserDto;

public final class MembershipRequestMapper {

	private MembershipRequestMapper() {
	}
	
	public static MembershipDto convertCreateRequestToDto(MembershipCreateRequest membershipCreateRequest) {
		MembershipDto membershipDto = new MembershipDto();
		UserDto userDto = new UserDto();
		LibraryDto libraryDto = new LibraryDto();
		
		membershipDto.setUser(userDto);
		membershipDto.setLibrary(libraryDto);
		membershipDto.setBeginningOfMembership(membershipCreateRequest.getBeginningOfMembershipDate());
		
		return membershipDto;
	}
	
	public static MembershipDto convertUpdateRequestToDto(MembershipUpdateRequest membershipUpdateRequest) {
		MembershipDto membershipDto = new MembershipDto();
		UserDto userDto = new UserDto();
		LibraryDto libraryDto = new LibraryDto();
		
		membershipDto.setId(membershipUpdateRequest.getId());
		membershipDto.setUser(userDto);
		membershipDto.setLibrary(libraryDto);
		membershipDto.setBeginningOfMembership(membershipUpdateRequest.getBeginningOfMembershipDate());
		
		return membershipDto;
	}
}
