package hu.simplesoft.springtutorial.Biblioteca.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hu.simplesoft.springtutorial.Biblioteca.controller.mapper.MembershipRequestMapper;
import hu.simplesoft.springtutorial.Biblioteca.controller.request.MembershipCreateRequest;
import hu.simplesoft.springtutorial.Biblioteca.controller.request.MembershipUpdateRequest;
import hu.simplesoft.springtutorial.Biblioteca.service.MembershipService;
import hu.simplesoft.springtutorial.Biblioteca.service.exception.ServiceException;
import hu.simplesoft.sprintutorial.Biblioteca.service.dto.MembershipDto;

@RestController
@RequestMapping("/membership")
public class MembershipController {

	@Autowired
	private MembershipService membershipService;
	
	public MembershipController() {
	}
	
	@PostMapping("/createMembership")
	public void createMembership(@Valid @RequestBody MembershipCreateRequest membershipCreateRequest) throws ServiceException{
		MembershipDto membershipDto = MembershipRequestMapper.convertCreateRequestToDto(membershipCreateRequest);
		this.membershipService.createMembership(membershipDto);
	}
	
	@PutMapping("/updateMembership")
	public void updateMembership(@Valid @RequestBody MembershipUpdateRequest membershipUpdateRequest) throws ServiceException{
		MembershipDto membershipDto = MembershipRequestMapper.convertUpdateRequestToDto(membershipUpdateRequest);
		this.membershipService.updateMembership(membershipDto);
	}
	
	@DeleteMapping("/deleteMembership/{id}")
	public void deleteMembership(@PathVariable @Positive long id) throws ServiceException{
		this.membershipService.deleteMembership(id);
	}
	
	@GetMapping("/getMembership/{id}")
	public MembershipDto getMembershipById(@PathVariable @Positive long id) throws ServiceException{
		MembershipDto membershipDto = this.membershipService.getMembershipById(id);
		return membershipDto;
	}
	
	@GetMapping("/getAllMemberships")
	public List<MembershipDto> getAllMemberships() throws ServiceException{
		List<MembershipDto> membershipDtoList = this.membershipService.getAllMemberships();
		return membershipDtoList;
	}
}
