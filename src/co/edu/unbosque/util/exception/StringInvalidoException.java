package co.edu.unbosque.util.exception;

/**
 * Excepción lanzada cuando una cadena de texto no cumple con los requisitos de
 * validación. Esta excepción se utiliza para indicar que el valor de texto
 * proporcionado no es válido según los criterios esperados.
 * 
 * @author Juan Martinez
 * @version 1.0
 */
public class StringInvalidoException extends Exception {

	/**
	 * Construye una nueva StringInvalidoException con un mensaje de error
	 * predeterminado. El mensaje indica que la entrada no es válida.
	 */
	public StringInvalidoException() {
		super("La entrada no es válida");
	}
}