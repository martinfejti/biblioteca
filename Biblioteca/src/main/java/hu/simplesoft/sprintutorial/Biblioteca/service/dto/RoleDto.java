package hu.simplesoft.sprintutorial.Biblioteca.service.dto;

public class RoleDto {

	private long id;
	private String roleName;
	
	public RoleDto() {
		
	}
	
	
	
	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getRoleName() {
		return roleName;
	}
	
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
}
