package hu.simplesoft.springtutorial.Biblioteca.controller.exception;

public class ExceptionObject {

	private String status;
	
	public ExceptionObject(String status) {
		this.status = status;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
}
