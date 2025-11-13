package co.edu.unbosque.util.exception;

/**
 * Excepción lanzada cuando una contraseña no cumple con los criterios de
 * fortaleza requeridos. Esta excepción se utiliza para indicar que la
 * contraseña proporcionada se considera débil y no satisface los requisitos de
 * seguridad.
 * 
 * @author Juan Martinez
 * @version 1.0
 */
public class ContraseniaDebilException extends Exception {

	/**
	 * Construye una nueva ContraseniaDebilException con un mensaje de error
	 * predeterminado. El mensaje indica que la contraseña es débil y no cumple con
	 * los estándares de seguridad requeridos.
	 */
	public ContraseniaDebilException() {
		super("La contraseña es débil");
	}

}