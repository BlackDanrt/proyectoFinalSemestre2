package co.edu.unbosque.util.exception;

public class CorreoInvalidoException extends Exception {

	public CorreoInvalidoException() {
		super("Invalid email, the email is not a real email");
	}

}
