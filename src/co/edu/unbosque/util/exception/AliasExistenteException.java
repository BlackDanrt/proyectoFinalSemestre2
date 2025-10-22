package co.edu.unbosque.util.exception;

public class AliasExistenteException extends Exception {

	public AliasExistenteException() {
		super("The alias is already in use, try another");
	}
}
