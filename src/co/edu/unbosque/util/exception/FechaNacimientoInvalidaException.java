package co.edu.unbosque.util.exception;

public class FechaNacimientoInvalidaException extends Exception {

	public FechaNacimientoInvalidaException() {
		super("The date of birth is invalid, the user muust be at least 18 year old");
	}

}
