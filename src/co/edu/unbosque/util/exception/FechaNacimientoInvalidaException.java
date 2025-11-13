package co.edu.unbosque.util.exception;

/**
 * Excepción lanzada cuando una fecha de nacimiento no cumple con los requisitos
 * de edad mínima. Esta excepción se utiliza para indicar que la fecha de
 * nacimiento proporcionada es inválida porque el usuario debe tener al menos 18
 * años de edad.
 * 
 * @author Juan Martinez
 * @version 1.0
 */
public class FechaNacimientoInvalidaException extends Exception {

	/**
	 * Construye una nueva FechaNacimientoInvalidaException con un mensaje de error
	 * predeterminado. El mensaje indica que la fecha de nacimiento es inválida y
	 * que el usuario debe tener al menos 18 años de edad.
	 */
	public FechaNacimientoInvalidaException() {
		super("La fecha de nacimiento es inválida, el usuario debe tener al menos 18 años");
	}

}