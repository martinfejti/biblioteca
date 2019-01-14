package hu.simplesoft.springtutorial.Biblioteca.service.exception;

public class ServiceException extends Exception{

	public ServiceException() {
	}
	
	public ServiceException(String message) {
		super(message);
	}
	
	public ServiceException(Throwable throwable) {
		super(throwable);
	}
	
	public ServiceException(String message, Throwable throwable) {
		super(message, throwable);
	}
}
