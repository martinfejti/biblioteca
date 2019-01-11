package hu.simplesoft.springtutorial.Biblioteca.data.util;

import hu.simplesoft.springtutorial.Biblioteca.data.exception.ObjectIsNullException;

public class Validator {

	public static void validateObject(Object o, long id) throws ObjectIsNullException{
		if(o == null) {
			throw new ObjectIsNullException("Object not found with id: " + id );
		}
	}
}
