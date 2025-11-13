package co.edu.unbosque.util.exception;

/**
 * Excepción lanzada cuando una dirección de correo electrónico no cumple con
 * los requisitos básicos de formato o se determina que es inválida por otras
 * razones. Esta excepción se utiliza para indicar que el correo proporcionado
 * no es una dirección de correo electrónico válida o real.
 * 
 * @author Juan Martinez
 * @version 1.0
 */
public class CorreoInvalidoException extends Exception {

	/**
	 * Construye una nueva CorreoInvalidoException con un mensaje de error
	 * predeterminado. El mensaje indica que el correo es inválido y no es una
	 * dirección de correo electrónico real.
	 */
	public CorreoInvalidoException() {
		super("Correo inválido, el correo no es una dirección de correo real");
	}

}