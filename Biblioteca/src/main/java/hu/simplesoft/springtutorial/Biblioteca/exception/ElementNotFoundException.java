package hu.simplesoft.springtutorial.Biblioteca.exception;

public class ElementNotFoundException extends PersistenceException{

	public ElementNotFoundException() {
		
	}
	
	public ElementNotFoundException(String message) {
		super(message);
	}
	
	public ElementNotFoundException(Throwable throwable) {
		super(throwable);
	}
	
	public ElementNotFoundException(String message, Throwable throwable) {
		super(message, throwable);
	}
}
