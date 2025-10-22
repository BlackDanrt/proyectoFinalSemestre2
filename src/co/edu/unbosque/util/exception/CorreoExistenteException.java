package co.edu.unbosque.util.exception;

public class CorreoExistenteException extends Exception {

	public CorreoExistenteException() {
		super("Invalid Email, The email is already in use");
	}

}
