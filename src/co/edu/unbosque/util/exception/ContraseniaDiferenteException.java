package co.edu.unbosque.util.exception;

/**
 * Excepción lanzada cuando dos entradas de contraseña no coinciden. Esta
 * excepción se utiliza para indicar que la confirmación de contraseña no
 * coincide con la entrada de contraseña original.
 * 
 * @author Juan Martinez
 * @version 1.0
 */
public class ContraseniaDiferenteException extends Exception {

	/**
	 * Construye una nueva ContraseniaDiferenteException con un mensaje de error
	 * predeterminado. El mensaje indica que las contraseñas proporcionadas no
	 * coinciden.
	 */
	public ContraseniaDiferenteException() {
		super("Las contraseñas son diferentes");
	}
}