package co.edu.unbosque.util.exception;

/**
 * Excepción lanzada cuando se intenta crear una cuenta o actualizar información
 * con una dirección de correo electrónico que ya existe en el sistema. Esta
 * excepción se utiliza para indicar que el correo proporcionado es inválido
 * porque ya está siendo utilizado por otro usuario.
 * 
 * @author Juan Martinez
 * @version 1.0
 */
public class CorreoExistenteException extends Exception {

	/**
	 * Construye una nueva CorreoExistenteException con un mensaje de error
	 * predeterminado. El mensaje indica que el correo es inválido porque ya está en
	 * uso.
	 */
	public CorreoExistenteException() {
		super("Correo inválido, el correo ya está en uso");
	}

}