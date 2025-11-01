package co.edu.unbosque.util.exception;

public class ContraseniaDiferenteException extends Exception {
	
	public ContraseniaDiferenteException() {
		super("The passwords are different");
	}
}
