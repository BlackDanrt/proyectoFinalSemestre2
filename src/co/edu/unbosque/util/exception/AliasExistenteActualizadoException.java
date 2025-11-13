package co.edu.unbosque.util.exception;

/**
 * Excepción lanzada cuando se intenta actualizar o crear un alias que ya
 * existe. Esta excepción se utiliza para indicar que el alias proporcionado es
 * inválido porque ya está siendo utilizado por otra entidad.
 * 
 * @author Juan Martinez
 * @version 1.0
 */
public class AliasExistenteActualizadoException extends Exception {

	/**
	 * Construye una nueva AliasExistenteActualizadoException con un mensaje de
	 * error predeterminado. El mensaje indica que el alias es inválido porque ya
	 * está en uso.
	 */
	public AliasExistenteActualizadoException() {
		super("Alias inválido, ya está en uso");
	}
}