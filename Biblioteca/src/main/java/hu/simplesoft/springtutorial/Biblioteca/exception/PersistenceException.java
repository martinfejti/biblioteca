package hu.simplesoft.springtutorial.Biblioteca.exception;

public class PersistenceException extends RuntimeException {

	public PersistenceException() {
		
	}
	
	public PersistenceException(String message) {
		super(message);
	}
	
	public PersistenceException(Throwable throwable) {
		super(throwable);
	}
	
	public PersistenceException(String message, Throwable throwable) {
		super(message, throwable);
	}
	
	
}
