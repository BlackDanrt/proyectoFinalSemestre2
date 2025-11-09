package co.edu.unbosque.util.exception;

public class AliasExistenteActualizadoException extends Exception {

	public AliasExistenteActualizadoException() {
		super("Invalid alias, its already in use");
	}
}
