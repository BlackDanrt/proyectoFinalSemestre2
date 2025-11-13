package co.edu.unbosque.util.exception;

/**
 * Excepción lanzada cuando una entrada no es un número válido. Esta excepción
 * se utiliza para indicar que el valor proporcionado no es numérico o no cumple
 * con el formato numérico esperado.
 * 
 * @author Juan Martinez
 * @version 1.0
 */
public class NumeroInvalidoException extends Exception {

	/**
	 * Construye una nueva NumeroInvalidoException con un mensaje de error
	 * predeterminado. El mensaje indica que la entrada es inválida y que se deben
	 * usar números.
	 */
	public NumeroInvalidoException() {
		super("Entrada inválida, usa números");
	}

}