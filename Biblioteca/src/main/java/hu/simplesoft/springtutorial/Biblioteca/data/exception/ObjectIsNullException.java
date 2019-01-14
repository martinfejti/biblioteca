package hu.simplesoft.springtutorial.Biblioteca.data.exception;

public class ObjectIsNullException extends PersistenceException{

	public ObjectIsNullException() {
	}
	
	public ObjectIsNullException(String message) {
		super(message);
	}
	
	public ObjectIsNullException(Throwable throwable) {
		super(throwable);
	}
	
	public ObjectIsNullException(String message, Throwable throwable) {
		super(message, throwable);
	}
}
